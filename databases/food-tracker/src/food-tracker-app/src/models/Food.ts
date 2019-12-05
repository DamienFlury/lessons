import Customer from './Customer';
import FoodType from './FoodType';

type Food = {
    id?: number,
    name: string,
    price: number,
    customer?: Customer,
    foodTypes?: FoodType[],
};

export default Food;
