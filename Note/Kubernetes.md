# <center>Kubernetes(K8S)</center>

[Kubernetes 官方](https://kubernetes.io/)

[Minikube 官方](https://minikube.sigs.k8s.io)

[Kubernetes 1小時入門課程 - 影片+筆記](https://geekhour.net/2023/12/23/kubernetes/) (GeekHour)

[Kubernetes 1小時輕鬆入門影片課程筆記](https://drive.google.com/drive/folders/1zPUlMoXD0eQtZ80zhMkivDD0cfo4J9hk) (GoogleDrive)

## Kubernetes (K8s) 功能與縮寫對照表

## 控制平面 (Control Plane)
| 名稱 | 縮寫 | 功能 |
|------|------|------|
| API Server | kube-apiserver | 提供 REST API，集群的入口，所有指令都經過它 |
| Controller Manager | kube-controller-manager | 管理控制迴圈，例如 ReplicaSet、Deployment 等 |
| Scheduler | kube-scheduler | 負責把 Pod 分配到合適的 Node |
| ETCD | etcd | 分散式 key-value 儲存，用來保存 Kubernetes 的狀態資料 |

---

## 節點組件 (Node Components)
| 名稱 | 縮寫 | 功能 |
|------|------|------|
| Kubelet | kubelet | 在每個節點上執行，負責管理 Pod 的生命週期 |
| Kube Proxy | kube-proxy | 管理網路規則，提供 Service 負載平衡 |
| Container Runtime | CRI | 容器運行時，例如 Docker、containerd |

---

## 核心物件 (Workloads / Objects)
| 名稱 | 縮寫 | 功能 |
|------|------|------|
| Pod | Pod | 最小的部署單位，可以包含一個或多個容器 |
| ReplicaSet | RS | 確保 Pod 數量符合需求 |
| Deployment | Deploy | 管理 ReplicaSet，支援滾動更新、回滾 |
| StatefulSet | STS | 管理有狀態應用，例如資料庫 |
| DaemonSet | DS | 確保每個 Node 都有一個 Pod（常用於監控、網路代理） |
| Job | Job | 一次性任務 |
| CronJob | CJ | 週期性任務（類似 Linux crontab） |

---

## 網路與服務發現 (Networking & Service Discovery)
| 名稱 | 縮寫 | 功能 |
|------|------|------|
| Service | SVC | 定義 Pod 的存取方式，支援 ClusterIP、NodePort、LoadBalancer |
| Ingress | Ingress | HTTP/HTTPS 路由，控制外部流量進入 |
| NetworkPolicy | NP | 控制 Pod 之間的網路存取 |

---

## 設定與存儲 (Config & Storage)
| 名稱 | 縮寫 | 功能 |
|------|------|------|
| ConfigMap | CM | 儲存非敏感配置（環境變數、設定檔） |
| Secret | Secret | 儲存敏感資訊（密碼、金鑰、憑證） |
| PersistentVolume | PV | 集群層級的存儲資源 |
| PersistentVolumeClaim | PVC | Pod 向 PV 請求存儲 |
| StorageClass | SC | 定義動態存儲配置 |

---

## 存取與安全 (Access & Security)
| 名稱 | 縮寫 | 功能 |
|------|------|------|
| Role / ClusterRole | Role / CR | 權限定義（RBAC） |
| RoleBinding / ClusterRoleBinding | RB / CRB | 綁定使用者與角色 |
| ServiceAccount | SA | Pod 使用的身份憑證 |

---

## 監控與命名空間 (Observability & Namespace)
| 名稱 | 縮寫 | 功能 |
|------|------|------|
| Namespace | NS | 隔離資源的邏輯空間 |
| ResourceQuota | RQ | 限制 NS 使用的資源 |
| LimitRange | LR | 限制 Pod/Container 的 CPU/Memory |
| HorizontalPodAutoscaler | HPA | 水平擴展 Pod |
| VerticalPodAutoscaler | VPA | 自動調整 Pod 的 CPU/Memory |
| CustomResourceDefinition | CRD | 自訂資源擴充 K8s API |

---

## `kubectl` 常用縮寫速查表
```bash
kubectl get pod      # Pod
kubectl get deploy   # Deployment
kubectl get svc      # Service
kubectl get cm       # ConfigMap
kubectl get ns       # Namespace
kubectl get rs       # ReplicaSet
kubectl get ds       # DaemonSet
kubectl get cj       # CronJob
kubectl get pv       # PersistentVolume
kubectl get pvc      # PersistentVolumeClaim
```

---

# 搭建環境練習

1. 先安裝 [Multipass](https://canonical.com/multipass/install) - 虛擬機管理工具 用於搭建Linux環境
    ## 常用命令
```cli
    # 查看説明
    multipass help
    multipass help <command>

    # 創建一個名字叫做k3s的虛擬機
    multipass launch --name k3s

    # 在虛擬機中執行命令
    multipass exec k3s -- ls -l

    # 進入虛擬機並執行shell
    multipass shell k3s

    # 查看虛擬機的資訊
    multipass info k3s

    # 停止虛擬機
    multipass stop k3s

    # 啟動虛擬機
    multipass start k3s

    # 刪除虛擬機
    multipass delete k3s

    # 清理虛擬機
    multipass purge

    # 查看虛擬機清單
    multipass list

    # 掛載目錄（將本地的~/kubernetes/master目錄掛載到虛擬機中的~/master目錄）
    multipass mount ~/kubernetes/master master:~/master
```

2. 建立虛擬機 依照電腦配備調整
```cli
    # 建立一個名為 k3s 的虛擬機
    multipass launch --name k3s --cpus 2 --memory 2G --disk 10G
    或
    multipass launch -n k3s -c 2 -m 2G -d 10G

    # 進入到 k3s 虛擬機中
    multipass shell k3s

    # 設定密碼
    sudo passwd 密碼

    # 啟用 SSH 登入(以下可選)
    sudo vim /etc/ssh/sshd_config

    # 確保以下三行是啟用的沒有被註解掉
    PubkeyAuthentication yes
    AuthorizedKeysFile     .ssh/authorized_keys
    PasswordAuthentication yes

    # 改完要重啟SSH
    sudo systemctl restart ssh
    或
    sudo systemctl restart sshd

    # 加入公鑰
    vim .ssh/authorized_keys

    # 公鑰來源 你的本機啟用終端輸入 
    ssh-keygen -t rsa -b 4096

    # 公鑰位置: ~/.ssh/id_rsa.pub

    # 將 id_rsa.pub 金鑰加入 authorized_keys 一行表示一個金鑰
    範例:
        ssh-rsa AAAAB3NzaC1yc2EAAAABIwAAAQEAw9Y... user1@host
        ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIC5X... user2@laptop
        ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQC3... deploy@server
```

3. 安裝 k3s - 輕量的K8S發行版
```cli
    # 在剛剛建立的 Linux 下安裝
    curl -sfL https://get.k3s.io | sh -

    # 安裝完成後可以查看集群狀態
    sudo kubectl get nodes

    # 取得Token
    sudo cat /var/lib/rancher/k3s/server/node-token

    # 取得IP
    ip addr

    # 補充...multipass關閉後重啟時IP可能會改變kubectl命令就會出問題
    解決方法:
        手動執行:
            1. 查看 VM 現在的 IP:
                ip addr

            2. 建立或修改 k3s config:
                sudo vim /etc/rancher/k3s/config.yaml

            3. 加入剛剛查到的IP:
                node-ip: <IP>
                flannel-iface: eth0            

            4. 重啟 k3s:
               sudo systemctl restart k3s 
        
        腳本執行:
            #!/bin/bash
            # ----------------------------------------------------
            # Script to automatically update k3s node-ip + systemd service
            # ----------------------------------------------------

            set -e

            echo "Creating k3s-auto-nodeip script..."

            # 1. Create k3s-auto-nodeip.sh
            cat << 'EOF' | sudo tee /usr/local/bin/k3s-auto-nodeip.sh >/dev/null
            #!/bin/bash
            # k3s-auto-nodeip.sh
            # Automatically update k3s node-ip and restart k3s

            CONFIG_FILE="/etc/rancher/k3s/config.yaml"

            # Get IPv4 of eth0
            NODE_IP=$(ip -4 addr show eth0 | grep -oP '(?<=inet\s)\d+(\.\d+){3}')

            if [ -z "$NODE_IP" ]; then
              echo "Cannot get eth0 IP, exiting..."
              exit 1
            fi

            # Create config.yaml if it does not exist
            if [ ! -f "$CONFIG_FILE" ]; then
              touch "$CONFIG_FILE"
            fi

            # Update or add node-ip
            if grep -q "^node-ip:" "$CONFIG_FILE"; then
              sed -i "s/^node-ip:.*/node-ip: $NODE_IP/" "$CONFIG_FILE"
            else
              echo "node-ip: $NODE_IP" >> "$CONFIG_FILE"
            fi

            # Update or add flannel-iface
            if grep -q "^flannel-iface:" "$CONFIG_FILE"; then
              sed -i "s/^flannel-iface:.*/flannel-iface: eth0/" "$CONFIG_FILE"
            else
              echo "flannel-iface: eth0" >> "$CONFIG_FILE"
            fi

            echo "Updated $CONFIG_FILE with node-ip=$NODE_IP"

            # Restart k3s
            systemctl restart k3s
            echo "k3s has been restarted"
            EOF

            sudo chmod +x /usr/local/bin/k3s-auto-nodeip.sh
            echo "k3s-auto-nodeip.sh has been created and made executable"

            # 2. Create systemd service
            echo "Creating systemd service..."
            cat << 'EOF' | sudo tee /etc/systemd/system/k3s-auto-nodeip.service >/dev/null
            [Unit]
            Description=Automatically update k3s node-ip and restart k3s
            After=network.target

            [Service]
            Type=oneshot
            ExecStart=/usr/local/bin/k3s-auto-nodeip.sh
            RemainAfterExit=true

            [Install]
            WantedBy=multi-user.target
            EOF

            # 3. Reload systemd and enable service
            sudo systemctl daemon-reload
            sudo systemctl enable k3s-auto-nodeip.service
            sudo systemctl start k3s-auto-nodeip.service

            echo "k3s-auto-nodeip service is enabled. It will automatically update node-ip and restart k3s at boot"
```

4. 建立 worker 節點
```cli
    multipass launch --name worker1 --cpus 2 --memory 2G --disk 10G
    multipass launch --name worker2 --cpus 2 --memory 2G --disk 10G

    # 進入到兩個 worker 輸入以下命令
    curl -sfL https://get.k3s.io | K3S_URL="https://<名為 k3s 的虛擬機IP>:6443" K3S_TOKEN="<名為 k3s 的虛擬機TOKEN>" sh -

    # 如果有出現錯誤
    Job for k3s-agent.service failed because the control process exited with error code.
    See "systemctl status k3s-agent.service" and "journalctl -xeu k3s-agent.service" for details.

    # 重置 agent 再試
    sudo k3s-agent-uninstall.sh
    curl -sfL https://get.k3s.io | K3S_URL="https://<名為 k3s 的虛擬機IP>:6443" K3S_TOKEN="<名為 k3s 的虛擬機TOKEN>" sh -
```

5. 回到名為 k3s 的虛擬機確認
```
    # 查看節點
    sudo kubectl get nodes

    # 這時會有三個節點
    NAME      STATUS   ROLES                  AGE   VERSION
    k3s       Ready    control-plane,master   55m   v1.33.4+k3s1
    worker1   Ready    <none>                 35m   v1.33.4+k3s1
    worker2   Ready    <none>                 34m   v1.33.4+k3s1
```
