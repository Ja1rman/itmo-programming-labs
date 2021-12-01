class MoveException() : Exception() {
    override fun toString(): String {
        return "Неверный запрос в больницу"
    }
}