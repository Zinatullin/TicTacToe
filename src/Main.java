public class Main {
    public static void main(String[] args) {
        char[][] field;
        field = new char[3][3];
        char x = 'X';
        char o = 'O';

        init(field);
        showField(field);

}

    static void init(char[][] f){
        char free = '-';
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                f[i][j]= free;
            }
        }
    }

    static void showField(char[][] sf){
        for (int i = 0; i < sf.length; i++) {
            for (int j = 0; j < sf[i].length; j++) {
                System.out.print(sf[i][j]);
            }
            System.out.println();
        }
    }

}
