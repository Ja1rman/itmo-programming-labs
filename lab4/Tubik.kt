class Tubik(name: String, status: String, var pom: Action) : Person(name, status){
    inner class genius{
        fun mainMind(){
            println("$name: Сообразил, что по трафарету, изготовленному рукой опытного мастера, каждый коротышка может заготовлять шаблоны")
            println("$name: Привлекает к этому делу Авоську")
            doNewDolz()
            pom.action()
        }
    }
    override fun action() {
        println("$name: Нарисовал множество шаблонных портретов, что очень ускоряло работу")
        genius().mainMind()
    }
    fun doNewDolz(){
        (pom as Person).status = "Помошник художника"
        println("${(pom as Person).name} Получил статус \"Помошник художника\"")
    }
    fun bestPic(): String{
        return if((1..2).random() == 1){
            "Портрет Снежинки"
        } else{
            "Портрет Синеглазки"
        }

    }
}