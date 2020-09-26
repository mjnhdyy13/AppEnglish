class Vocal {
    var english : String = ""
    var vietnam : String = ""
    var tuloai : String = ""

    constructor()
    constructor(english: String, vietnam: String, tuloai: String) {
        this.english = english
        this.vietnam = vietnam
        this.tuloai = tuloai
    }

    override fun toString(): String {
        return "$english\t($tuloai)\t$vietnam"
    }


}