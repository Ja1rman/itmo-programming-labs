enum class Wishes(val title: String) {
    SOUP("Требую на обед варили суп из конфет и кашу из мармелада"),
    CAULDRON("Заказываю котлеты из земляники с грибным соусом"),
    PUREE("Приказываю принести яблочное пюре");

    override fun toString(): String {
        return "Wishes{" +
                "title='" + title + '\'' +
                '}'
    }
}