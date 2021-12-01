class StatusException(except: () -> Unit) : Exception() {
    override fun toString(): String {
        return "В больнице чужак"
    }
}