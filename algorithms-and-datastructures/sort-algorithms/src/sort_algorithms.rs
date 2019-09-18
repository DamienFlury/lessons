
pub fn bubble_sort<T: PartialOrd>(array: &mut [T]) -> &[T] {
    let length = array.len();
    for i in (0..length - 1).rev() {
        for j in i..length - 1 {
            if array[j] > array[j + 1] {
                array.swap(j, j + 1);
            }
        }
    }
    array
}

pub fn selection_sort<T: PartialOrd>(array: &mut [T]) -> &[T] {
    for i in 0..array.len() {
        let lowest_index = get_lowest_index(&array[i..array.len()]);
        array.swap(i, i + lowest_index);
    }
    array
}

pub fn insertion_sort<T: PartialOrd>(array: &mut [T]) -> &[T] {
    for i in 0..array.len() {
        for j in (0..i).rev() {
            if array[j] >= array[j + 1] {
                array.swap(j, j + 1);
            }
        }
    }
    array
}

fn get_lowest_index<T: PartialOrd>(slice: &[T]) -> usize {
    let mut min = &slice[0];
    let mut min_index = 0;

    for (index, item) in slice.iter().enumerate() {
        if item < min {
            min = item;
            min_index = index;
        }
    }
    min_index
}