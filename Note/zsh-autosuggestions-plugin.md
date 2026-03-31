# Oh My Zsh

1. Clone this repository into $ZSH_CUSTOM/plugins (by default ~/.oh-my-zsh/custom/plugins)
    ```
    git clone https://github.com/zsh-users/zsh-autosuggestions ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-autosuggestions
    ```

2. Add the plugin to the list of plugins for Oh My Zsh to load (inside ~/.zshrc):

    ```
        plugins=( 
            # other plugins...
            zsh-autosuggestions
        )
    ```

3. Start a new terminal session.

# Homebrew

1. Install command:
    ```
        brew install zsh-autosuggestions
    ```

2. To activate the autosuggestions, add the following at the end of your .zshrc:
    ```
        source $(brew --prefix)/share/zsh-autosuggestions/zsh-autosuggestions.zsh
    ```

3. Start a new terminal session.

