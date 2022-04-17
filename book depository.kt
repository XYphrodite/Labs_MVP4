fun cleanConsole() {
    println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
}

class book(private var _name: String, private var _author: String, private var _realese_date: Int) {
    private var name: String = this._name
    private var author: String = this._author
    private var realese_date: Int = this._realese_date
    fun getName(): String {
        return name
    }

    fun getAuthor(): String {
        return author
    }

    fun getRealeseDate(): Int {
        return realese_date
    }

    fun showInfo() {
        println("Название: $name\nАвтор: $author\nГод издания: $realese_date")
    }
}

fun main() {
    val book_depository = mutableListOf<book>()
    var command: Int = 0
    while (true) {
        println("Введите 1 чтобы добавить книгу.")
        println("Введите 2 чтобы удалить книгу.")
        println("Введите 3 чтобы показать все книги.")
        println("Введите 4 чтобы показать книги по определённому параметру.")
        command = readLine()!!.toInt()
        cleanConsole()
        when {
            command == 1 -> {
                cleanConsole()
                print("\nВведите название\t")
                var name: String = readLine()!!.toString()
                print("\nВведите автора\t\t")
                var author: String = readLine()!!.toString()
                print("\nВведите год издания\t")
                var date: Int = readLine()!!.toInt()
                println()
                val instance = book(name, author, date)
                book_depository.add(instance)
                cleanConsole()
                println("Книга добавлена\n")
            }
            command == 2 -> {
                println("\nВведите порядковый номер книги")
                var number: Int = readLine()!!.toInt()
                if (number > book_depository.size) {
                    println("Не существует книги с таким порядковым номером\n\n")
                } else {
                    book_depository[number].showInfo()
                    book_depository.removeAt(number - 1)
                    println("Книга удалена успешно\n\n")
                }
            }
            command == 3 -> {
                cleanConsole()
                println("Начало списка\n")
                var number: Int = 0
                for (i in book_depository) {
                    number++
                    println("Порядковый номер $number")
                    i.showInfo()
                    println()
                }
                println("Конец списка\n\n")
            }
            command == 4 -> {
                println("Введите 1 если по названию")
                println("Введите 2 если по автору")
                println("Введите 3 если по году издания")
                command = readLine()!!.toInt()
                when {
                    command == 1 -> {
                        var number: Int = 0
                        print("Введите название\t")
                        var name: String = readLine().toString()
                        cleanConsole()
                        println("Начало списка\n")
                        for (i in book_depository) {
                            number++
                            if (i.getName().contains(name)) {
                                println("Порядковый номер $number")
                                i.showInfo()
                                println()
                            }
                        }
                        println("Конец списка\n\n")
                    }
                    command == 2 -> {
                        var number: Int = 0
                        print("Введите автора\t")
                        var author: String = readLine().toString()
                        cleanConsole()
                        println("Начало списка\n")
                        for (i in book_depository) {
                            number++
                            if (i.getAuthor().contains(author)) {
                                println("Порядковый номер $number")
                                i.showInfo()
                                println()
                            }
                        }
                        println("Конец списка\n\n")
                    }
                    command == 3 -> {
                        var number: Int = 0
                        print("Введите 1 если хотите определённый год издания\n")
                        print("Введите 2 если хотите после определённого года\n")
                        print("Введите 3 если хотите до определённого года издания\n")
                        command = readLine()!!.toInt()
                        when {
                            command == 1 -> {
                                var number: Int = 0
                                print("Введите год\t")
                                var date: Int = readLine()!!.toInt()
                                cleanConsole()
                                println("Начало списка\n")
                                for (i in book_depository) {
                                    number++
                                    if (i.getRealeseDate() == date) {
                                        println("Порядковый номер $number")
                                        i.showInfo()
                                        println()
                                    }
                                }
                                println("Конец списка\n\n")
                            }
                            command == 2 -> {
                                var number: Int = 0
                                print("Введите год\t")
                                var date: Int = readLine()!!.toInt()
                                cleanConsole()
                                println("Начало списка\n")
                                for (i in book_depository) {
                                    number++
                                    if (i.getRealeseDate() >= date) {
                                        println("Порядковый номер $number")
                                        i.showInfo()
                                        println()
                                    }
                                }
                                println("Конец списка\n\n")
                            }
                            command == 3 -> {
                                var number: Int = 0
                                print("Введите год\t")
                                var date: Int = readLine()!!.toInt()
                                cleanConsole()
                                println("Начало списка\n")
                                for (i in book_depository) {
                                    number++
                                    if (i.getRealeseDate() <= date) {
                                        println("Порядковый номер $number")
                                        i.showInfo()
                                        println()
                                    }
                                }
                                println("Конец списка\n\n")
                            }
                        }
                    }
                }
            }
        }
    }
}