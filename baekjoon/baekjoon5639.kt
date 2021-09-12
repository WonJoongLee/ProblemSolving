fun main() {
    data class Node(
        var left: Node?,
        var right: Node?,
        var value: Int,
        val root: Node?
    ) {
        fun insert() {
            var tempRoot = root
            var insertFlag = false
            while (tempRoot!!.left != null || tempRoot.right != null) {
                if (value < tempRoot.value) {
                    if (tempRoot.left == null) {
                        tempRoot.left = this
                        insertFlag = true
                        break
                    } else {
                        tempRoot = tempRoot.left!!
                    }
                } else if (value > tempRoot.value) {
                    if (tempRoot.right == null) {
                        tempRoot.right = this
                        insertFlag = true
                        break
                    } else {
                        tempRoot = tempRoot.right!!
                    }
                }
            }
            if (tempRoot.left == null && tempRoot.right == null) {
                if (value < tempRoot.value) {
                    tempRoot.left = this
                } else {
                    tempRoot.right = this
                }
            }
        }
    }


    val root = Node(null, null, readLine()!!.toInt(), null)
    while (true) {
        val now = readLine()
        if (now == null || now == "")
            break
        val newNode = Node(null, null, now.toInt(), root)
        newNode.insert()
    }

    fun postOrder(root: Node) {
        root.left?.let {
            postOrder(it)
        }
        root.right?.let {
            postOrder(it)
        }
        println(root.value)
    }

    postOrder(root)
}