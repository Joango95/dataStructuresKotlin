import java.time.Instant

fun selectionSort(itemList: List<Int>): List<Int> {
    val startTime = Instant.now()

    val mutableItemList = mutableListOf(itemList).flatten().toMutableList()
    var swappedItem: Int
    for (i in itemList.size - 1 downTo 0 step 1) {
    var smallest = mutableItemList[itemList.size - 1 - i]
        for(j in i downTo 1 step 1)
            if (mutableItemList[itemList.size - j] <= smallest) {
                swappedItem = mutableItemList[itemList.size - j]
                mutableItemList[itemList.size - j] = smallest
                smallest = swappedItem
            }
        mutableItemList[itemList.size - 1 - i] = smallest
    }

    val endTime = Instant.now()
    val duration = endTime.toEpochMilli() - startTime.toEpochMilli()
    println("Selection sort took $duration ms")
    println(mutableItemList)

    return mutableItemList.toList()

}