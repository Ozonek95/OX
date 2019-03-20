package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class Menu {
    private InputProvider inputProvider;
    private MessageProviderBasedOnLanguage messageProviderBasedOnLanguage = new MessageProviderBasedOnLanguage();
    private Settings settings;

    {
        try {
            settings = new Settings(3,3,3);
        } catch (IllegalGameSettings illegalGameSettings) {
            illegalGameSettings.printStackTrace();
        }
    }

    Menu(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    void startMenu(){
        chooseLanguage();
        boolean gameStarted = false;
        while (!gameStarted){
            System.out.println(messageProviderBasedOnLanguage.provideMessage("createSettings"));
            System.out.println(messageProviderBasedOnLanguage.provideMessage("startGame"));
            System.out.println(messageProviderBasedOnLanguage.provideMessage("changeLanguage"));
            int choice = Integer.parseInt(inputProvider.getInput());
            switch (choice){
                case 1: settings=createSettings(); break;
                case 2: playGame(); gameStarted = true; break;
                case 3:chooseLanguage();
            }
        }

    }

    private void playGame() {
        Game game = new Game(settings,messageProviderBasedOnLanguage);
        game.playMatch();
    }

    private void chooseLanguage() {
        boolean languageProvided = false;
        while (!languageProvided){
            System.out.println("Choose language / Wybierz język");
            System.out.println("1. English");
            System.out.println("2. Polish");
            try {
                int input = Integer.parseInt(inputProvider.getInput());
                switch (input){
                    case 1: messageProviderBasedOnLanguage.changeLanguage(Language.EN); languageProvided=true; break;
                    case 2: messageProviderBasedOnLanguage.changeLanguage(Language.PL); languageProvided=true; break;
                    default: throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e){
                System.err.println("Provide valid option / Wybierz poprawną opcję.");
            }
        }
    }

    Settings createSettings() {
        boolean correctSettings = false;
        Settings settings = null;
        while (!correctSettings){
            try {
                System.out.println(messageProviderBasedOnLanguage.provideMessage("numberOfRows"));
                int rows = Integer.parseInt(inputProvider.getInput());
                System.out.println(messageProviderBasedOnLanguage.provideMessage("numberOfColumns"));
                int columns = Integer.parseInt(inputProvider.getInput());
                System.out.println(messageProviderBasedOnLanguage.provideMessage("patternToWinLength"));
                int patternToWin = Integer.parseInt(inputProvider.getInput());
                if(rows<1||columns<1||patternToWin<1){
                    throw new IllegalGameSettings("Parameters must be positive numbers");
                }
                settings = new Settings(rows,columns,patternToWin);
                correctSettings=true;
            } catch (NumberFormatException e){
                System.err.println(messageProviderBasedOnLanguage.provideMessage("invalidInput"));
            } catch (IllegalGameSettings e){
                System.err.println(messageProviderBasedOnLanguage.provideMessage("invalidInput"));
            }
        }
        return settings;

    }

    void setMessageProviderBasedOnLanguage(MessageProviderBasedOnLanguage messageProviderBasedOnLanguage) {
        this.messageProviderBasedOnLanguage = messageProviderBasedOnLanguage;
    }
}
