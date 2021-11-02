public enum Wishes {
    SOUP ("Требую на обед варили суп из конфет и кашу из мармелада"),
    CAULDRON ("Заказываю котлеты из земляники с грибным соусом"),
    PUREE ("Приказываю принести яблочное пюре");

    private String title;

    Wishes(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Wishes{" +
                "title='" + title + '\'' +
                '}';
    }
}