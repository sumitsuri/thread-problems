https://github.com/DigiAshish/Java-Ludo-Game/blob/master/LudoGameHandler.java#L1256

Player
    color: string
    pieces: List<Piece>
    rolledNumber: int
    isSixRolled: int
    

Piece
    number: int
    color: string
    position: Position
    takenOut: boolean
    isComplete: boolean

Position:
    xCoordinate: int
    yCoordinate: int
Dice
    rollDice(): int

LudoBoard
    int[][] squares = new int[15][15]
    int[][] greenHomePosition = {{2,2},{2,3},{3,2},{3,3}}
    int[][] redHomePosition = {{2,2},{2,3},{3,2},{3,3}}
    int[][] yellowHomePosition = {{2,2},{2,3},{3,2},{3,3}}
    int[][] blueHomePosition = {{2,2},{2,3},{3,2},{3,3}}
    int[][] greenPath = {{},{},{}}
    int[][] redPath = {{},{},{}}
    int[][] yellowPath = {{},{},{}}
    int[][] bluePath = {{},{},{}}
    //Color pathMapping
    Map<String, int[][]> pathMap;
    //Color homePositionMapping
    Map<String, int[][]> homePositionMap;
    Piece[][][] pieceRecordPosition = new Piece[15][15][4]
    

Runner
    List<Player> players;
    LudoBoard ludoBoard;
    Player currentPlayer;
    String[] color = {RED, BLUE, GREEN, YELLOW}
