class StartPainters : Run(){
    override fun start() {
        for (pers in super.persons) {
            if((pers as Person).status == "Помошник Художника"){
                println(pers.name + ": Гордится своей новой должностью и Говорит с гордостью: \"Мы -- художники\"")
            }
            else if (pers.status == "Художник"){
                pers.action()
                println("Лучший портрет ${pers.name}: " + (pers as Tubik).bestPic())
                println(pers.name + ": Не доволен своей работой и называет её халтурой. Все портреты кроме двух годятся лишь на то, чтобы покрывать ими горшки и кастрюли.")
            }
        }
        val uch = object {
            var phrase = "Сходство -- это дело десятое. На все можно смотреть по-разному."
            fun sayPhrase(){
                println("Обладательницам портретов нравилось, что они получились красивыми. Они говорят: $phrase")
            }
        }
        uch.sayPhrase()
    }
}