object HospitalSlave : HospitalAction {
    class Hyan(var Bname: String){
        fun rave(){
            println("Все нянечки сбились с ног, исполняя капризы $Bname. Они говорили, что у них спокон веку такого больного не было, что это сущее наказание, а не больной, и чтобы он выздоравливал уж поскорее, что ли.")
        }
        fun mindGames(){
            println("Нянечка устала шататься по городу, она возвращается в больницу в надежде, что он уже забыл о своей собаке,")
        }
    }
    fun action(action: String?, pers: Person) {
        when (action) {
            "Убежал из больницы" -> println("Обслуживающий персонал больницы больше не занимается " + pers.name)
            "Приказываю принести яблочное пюре" -> {
                println("Обслуживающий персонал больницы принёс яблочкное пюре для " + pers.name)
                pers.action()
            }
            "Я просил грушевого квасу" -> {
                println("Обслуживающий персонал больницы принёс грушевый квас для " + pers.name)
                pers.action()
            }
            "Квас воняет луком" -> println("Обслуживающий персонал больницы в тильте и хейтит позера " + pers.name)
            "Заказываю котлеты из земляники с грибным соусом" -> println("Обслуживающий персонал больницы считает, что таких котлет не бывает")
            else -> println("Обслуживающий персонал больницы принёс заказ для " + pers.name)
        }
    }
}