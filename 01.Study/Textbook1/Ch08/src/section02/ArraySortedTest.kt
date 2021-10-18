package section02

import java.util.*

fun main()
{
    val arr = arrayOf(8, 4, 3, 2, 5, 9, 1)

    val sorteNums = arr.sortedArray()
    println("ASC : " + Arrays.toString(sorteNums))

    val sortedNumsDesc = arr.sortedArrayDescending()
    println("DEC : " + Arrays.toString(sortedNumsDesc))

    arr.sort(1, 3)
    // public static void sort(int[] a, int fromIndex, int toIndex)
    // int[] intArr = new int[] {1,3,5,2,4}; Arrays.sort(intArr,2,5);
    // intArr[2]~intArr[4]의 값 (5,2,4) 만 정렬 (toIndex 이전 index까지
    // 출처: https://ifuwanna.tistory.com/232 [IfUwanna IT]
    println("ORI : " + Arrays.toString(arr))
    arr.sortDescending()
    println("ORI : " + Arrays.toString(arr))

    val listSorted : List<Int> = arr.sorted()
    val listDesc : List<Int> = arr.sortedDescending()
    println("LST : " + listSorted)
    println("LST : " + listDesc)

    val items = arrayOf("Dog", "Cat", "Lion", "Kangaroo", "Po")
    items.sortBy { item -> item.length }
    println(Arrays.toString(items))
}