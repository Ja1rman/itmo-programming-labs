
class Hospital : Run(){
    override fun start() {
        for (pers in super.persons) {
            try {
                if(!(pers as Person).status.contains("Больной", ignoreCase = true))throw StatusException{}
                pers.action()
            }
            catch (e: StatusException){
                println(e.toString())
                println("Чужак - ${(pers as Person).name}")
            }
        }
    }
}