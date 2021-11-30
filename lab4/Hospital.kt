
class Hospital : Run(){
    override fun start() {
        for (pers in super.persons) {
            pers.action()
        }
    }
}