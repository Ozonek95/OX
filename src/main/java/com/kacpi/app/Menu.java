package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class Menu {
    private InputProvider inputProvider;
    private MessagePrinter messageProvider = new MessagePrinter();
    private Settings settings;
    {
        try {
            settings = new Settings(3,3,3);
        } catch (IllegalGameSettings illegalGameSettings) {
            illegalGameSettings.printStackTrace();
        }
    }

    /**
     * @param inputProvider to interact with user.
     *                      Provides possibility to change options, and run new game.
     */
    Menu(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    /**
     * Switch to change options, or run new game.
     */
    void startMenu(){
        chooseLanguage();
        boolean gameStarted = false;
        while (!gameStarted){
            System.out.println(messageProvider.provideMessage("createSettings"));
            System.out.println(messageProvider.provideMessage("startGame"));
            System.out.println(messageProvider.provideMessage("changeLanguage"));
            System.out.println(messageProvider.provideMessage("changePlayerNames"));
            int choice = Integer.parseInt(inputProvider.getInput());
            switch (choice){
                case 1: settings=createSettings();
                break;
                case 2:
                    playGame();
                    gameStarted = true;
                    break;
                case 3:
                    chooseLanguage();
                    break;
                case 4:
                    changePlayersNames();
                    break;
            }
        }

    }

    private void changePlayersNames() {
        System.out.println(messageProvider.provideMessage("name1"));
        settings.getPlayers().get(0).setName(inputProvider.getInput());
        System.out.println(messageProvider.provideMessage("name2"));
        settings.getPlayers().get(1).setName(inputProvider.getInput());
    }

    /**
     * Asks about first player, starts game.
     */
    private void playGame() {
        boolean playerChosen = false;
        while (!playerChosen) {
            System.out.println(messageProvider.provideMessage("whoStarts"));
            System.out.println("1:" + settings.getPlayers().get(0).getName());
            System.out.println("2:" + settings.getPlayers().get(1).getName());
            try {
                int choice = Integer.parseInt(inputProvider.getInput());
                if (choice == 2) {
                    settings.changePlayers();
                }
                playerChosen = true;
            } catch (NumberFormatException exception) {
                messageProvider.provideMessage("invalidInput");
            }
        }
        Game game = new Game(settings, messageProvider, inputProvider,new GameInformation(settings));
        game.playMatch();
    }

    /**
     * @return settings, that were changed by user.
     */
    Settings createSettings() {
        boolean correctSettings = false;
        while (!correctSettings){
            try {
                System.out.println(messageProvider.provideMessage("numberOfRows"));
                int rows = Integer.parseInt(inputProvider.getInput());
                System.out.println(messageProvider.provideMessage("numberOfColumns"));
                int columns = Integer.parseInt(inputProvider.getInput());
                System.out.println(messageProvider.provideMessage("patternToWinLength"));
                int patternToWin = Integer.parseInt(inputProvider.getInput());
                checkGameCoordinatesAreValid(rows, columns, patternToWin);
                settings.setRows(rows);
                settings.setColumns(columns);
                settings.setPatternToWinLength(patternToWin);
                correctSettings=true;
            } catch (NumberFormatException | IllegalGameSettings e) {
                System.err.println(messageProvider.provideMessage("invalidInput"));
            }
        }
        return settings;

    }

    private void checkGameCoordinatesAreValid(int rows, int columns, int patternToWin) throws IllegalGameSettings {
        if (rows < 3 || columns < 3 || patternToWin < 3 || patternToWin > columns || patternToWin > rows) {
            throw new IllegalGameSettings("Parameters must be positive numbers");
        }
    }

    /**
     * Can change game language.
     */
    private void chooseLanguage() {
        boolean languageProvided = false;
        while (!languageProvided){
            System.out.println("Choose language / Wybierz język");
            System.out.println("1. English");
            System.out.println("2. Polish");
            try {
                int input = Integer.parseInt(inputProvider.getInput());
                switch (input){
                    case 1:
                        messageProvider.changeLanguage(Language.EN);
                        languageProvided = true;
                        break;
                    case 2:
                        messageProvider.changeLanguage(Language.PL);
                        languageProvided = true;
                        break;
                    default: throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e){
                System.err.println("Provide valid option / Wybierz poprawną opcję.");
            }
        }
    }

    void setMessageProvider(MessagePrinter messageProvider) {
        this.messageProvider = messageProvider;
    }

    Settings getSettings() {
        return settings;
    }
}
