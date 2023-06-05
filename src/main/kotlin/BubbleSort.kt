import java.time.Instant

/**
Repeatedly swapping the adjacent elements if they are in the wrong order
The Smallest value will get to beginning while largest value will get to end of list
Iterate over all items every n size until it is sorted.
One iterator to go n (size) times over it, the one iteration to compare adjacent items.
If next item is null, it is the last item on list.

Create a variable to check if an element was swapped, if not it is sorted.
Best case is only iterate over the list one time, n
Worst case is iterate over it n times, this means n*n
Big O notation : O(n2)

 */
fun bubbleSort(itemList: List<Int>): List<Int> {
    val startTime = Instant.now()

    val mutableItemList = mutableListOf(itemList).flatten().toMutableList()
    for (i in itemList.size downTo 0 step 1) {
        var switched = false
        mutableItemList.forEachIndexed { index, item ->
            val nextItem = mutableItemList.getOrNull(index + 1)
            if (nextItem == null) {
                mutableItemList[index] = item
            } else {
                if (item >= nextItem) {
                    switched = true
                    mutableItemList[index + 1] = item
                    mutableItemList[index] = nextItem
                }
            }
        }
        if (!switched) {
            break
        }
        switched = false
    }
    val endTime = Instant.now()
    val duration = endTime.toEpochMilli() - startTime.toEpochMilli()
    println("Bubble sort took $duration ms")
    println(mutableItemList)

    return mutableItemList.toList()
}