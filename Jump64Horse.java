public class Jump64Horse {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Table table = new Table();
        //table_print(table, "Početak");
        table.jump(2, 2, 1);
        table.print("++:Kraj:++*", 3);

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Total execution time: " + (float)elapsedTime/1000000000);

    }
}
