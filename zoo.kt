class Zoo() {
    private class Aviary() {
        private class Animal() {
            private var name: String = ""
            private var sex: String = ""
            private var sound: String = ""
            fun getName(): String {
                if (name == "") return "unknown"
                return name
            }

            fun getSex(): String {
                if (sex == "") return "unknown"
                return sex
            }

            fun getSound(): String {
                if (sound == "") return "unknown"
                return sound
            }

            fun setName(n: String) {
                name = n
            }

            fun setSex(s: String) {
                sex = s
            }

            fun setSound(s: String) {
                sound = s
            }

            fun setAll(_name: String, _sex: String, _sound: String) {
                name = _name
                sex = _sex
                sound = _sound
            }

            fun setTemplate(_name: String, _sex: String) {
                when {
                    _name == "lion" -> {
                        name = "lion"
                        sound = "roar"
                    }
                    _name == "monkey" -> {
                        name = "monkey"
                        sound = "loud call"
                    }
                    _name == "tiger" -> {
                        name = "tiger"
                        sound = "roar"
                    }
                    _name == "dove" -> {
                        name = "dove"
                        sound = "url..."
                    }
                    _name == "elephant" -> {
                        name = "elephant"
                        sound = "super loud and long call"
                    }
                    _name == "bird" -> {
                        name = "bird"
                        sound = "chirp"
                    }
                }
                sex = _sex
            }
        }

        private var inhabitants = mutableListOf<Animal>()
        private var number: Int = 0
        fun inhabit(n: Int, _name: String, _sex: String) {
            for (i in 1..n) {
                var a = Animal()
                a.setTemplate(_name, _sex)
                inhabitants.add(a)
            }
        }

        fun clear() {
            inhabitants.clear()
        }

        fun getNumber(): Int {
            return number
        }

        fun showInfo() {
            if (inhabitants.isEmpty()) {
                println("This aviary is empty")
                return
            }
            var amount_of_male: Int = 0
            var amount_of_female: Int = 0
            for (i in inhabitants) {
                if (i.getSex() == "male") amount_of_male++
                else amount_of_female++
            }
            println("${inhabitants[0].getName()}(-s/-es/-ies) is/are live/lives here")
            println("$amount_of_male male(-s) and $amount_of_female female(-s)")
            println("It/They make(-s) ${inhabitants[0].getSound()}")
        }
    }


    private var aviaries = mutableListOf<Aviary>()
    private var array_of_types = arrayListOf<String>("lion", "tiger", "monkey", "bird", "elephant", "dove")
    fun create() {
        var a1 = Aviary()
        var a2 = Aviary()
        var a3 = Aviary()
        var a4 = Aviary()
        var a5 = Aviary()
        var a6 = Aviary()
        a1.inhabit(1, array_of_types[0], "male")
        a1.inhabit(3, array_of_types[0], "female")
        a2.inhabit(1, array_of_types[1], "male")
        a2.inhabit(3, array_of_types[1], "female")
        a3.inhabit(5, array_of_types[2], "male")
        a3.inhabit(8, array_of_types[2], "female")
        a4.inhabit(12, array_of_types[3], "male")
        a4.inhabit(14, array_of_types[3], "female")
        a5.inhabit(1, array_of_types[4], "maele")
        a6.inhabit(13, array_of_types[5], "male")
        aviaries.add(a1)
        aviaries.add(a2)
        aviaries.add(a3)
        aviaries.add(a4)
        aviaries.add(a5)
        aviaries.add(a6)
    }

    fun getNumber(): Int {
        return aviaries.size
    }

    fun comeToAviary(num: Int) {
        if (num >= aviaries.size) {
            println("Not exist")
            return
        }
        aviaries[num].showInfo()
    }
}

fun main() {
    var zoo = Zoo()
    zoo.create()
    println("There are ${zoo.getNumber()} aviaries")
    while (true) {
        println("Input number of aviary that you want to come")
        zoo.comeToAviary(readLine()!!.toInt() - 1)
    }
}