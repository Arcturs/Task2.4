package ru.vsu.csf.Sashina;

public class QuickSelect {

    private int partition (int [] arr, int left, int right) {
        int pivot = arr[right]; //выбираем "точку вращения" - конечный эл-т
        //pivot можно взять любым, в любом случае сложность в среднем и лучшем случаях будет O(n)
        int tleft = left; //маркер для левой стороны
        for (int i = left; i <= right; i++) {
            if (arr[i] < pivot) { //если какой-то эл-т меньше "точки вращения"
                int temp = arr[i];
                arr[i] = arr [tleft];
                arr[tleft] = temp;
                //меняем местами эти элементы, т.о. перед "точкой вращения" выталкиваеся эл-т больший чем правая граница
                tleft++; //сдвигаем маркер
            }
        }
        //по итогу в tleft записан порядковый номер эл-та, большего чем правая граница
        int temp = arr[right];
        arr[right] = arr[tleft];
        arr[tleft] = temp;
        //меняем местами эл-ты, т.о. в правой границе находится эл-т больше чем до вызова функции
        //tleft принимает значение правой границы до обработки
        return tleft;
    }

    private int select (int [] arr, int left, int right, int k) {
        int pivotIn = partition(arr, left, right);
        if (pivotIn == k) {
            return arr[pivotIn];
        } else if (pivotIn < k) {
            return select(arr,pivotIn + 1, right, k);
            //обрабатывается правая сторона
        } else {
            return select (arr, left, pivotIn - 1, k);
            //обрабатывается левая сторона
        }
    }

    public int quickSelect (int [] arr, int left, int right, int k) {
        return select(arr, left, right, k);
        //в отличие от QuickSort обрабатывает только ту сторону, где содержится k
    }

    //худший случай (для "оси" = самой правой границы): заранее отсортированный массив, а искать надо самый первый эл-т
}
