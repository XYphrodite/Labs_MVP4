class Item() {
    private var name: String = "—"
    fun setName(n: String) {
        name = n
    }

    fun getName(): String {
        return name
    }
}

class Seller() {
    private var inventory = mutableListOf<Item>()
    private var void_item = Item()
    fun showInventory() {
        if (inventory.isEmpty()) {
            println("Inventory is empty")
        } else {
            var number: Int = 0
            for (i in inventory) {
                number++
                println("$number.${i.getName()}")
            }
        }
    }

    fun toSell(number: Int): Item {
        if (number > inventory.size) {
            println("This item doesn't exist")
            return void_item
        }
        var i: Item = inventory[number - 1]
        inventory.removeAt(number - 1)
        return i
    }

    fun fillInventory() {
        var arr = arrayListOf<String>("Sword", "Magic stick", "shield", "health potion", "book")
        for (i in arr) {
            var it = Item()
            it.setName(i)
            inventory.add(it)
        }
    }
}

class Player() {
    private var inventory = mutableListOf<Item>()
    fun showInventory() {
        if (inventory.isEmpty()) {
            println("Inventory is empty")
        } else {
            var number: Int = 0
            for (i in inventory) {
                number++
                println("$number.${i.getName()}")
            }
        }
    }

    fun toBuy(i: Item) {
        if (i.getName() == "—") {
            return
        }
        inventory.add(i)
        println("Item was added")
    }
}

fun main() {
    var I = Player()
    var Jack = Seller()
    Jack.fillInventory()
    var command: Int
    while (true) {
        println("Input 1 to open your inventory.")
        println("Input 2 to open seller's inventory")
        command = readLine()!!.toInt()
        if (command == 1) {
            I.showInventory()
        } else if (command == 2) {
            Jack.showInventory()
            println("Input number of item to buy ot input 0 to close")
            command = readLine()!!.toInt()
            if (command != 0) {
                I.toBuy(Jack.toSell(command))
            } else continue
        }
    }
}