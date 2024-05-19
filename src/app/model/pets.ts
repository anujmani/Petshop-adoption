export class Pet {
    static find(arg0: (pet: any) => boolean): Pet | undefined {
      throw new Error('Method not implemented.');
    }
    id: number | undefined;
    name: string | undefined;
    type: string | undefined;
    description: string |undefined;
    highlighted: boolean | undefined;
    age: number | undefined;
    photoUrl: string;
    price: number | undefined;

    constructor(data: {
        price: number | undefined; id: number | undefined; name: string | undefined; type: string | undefined; age: number | undefined; photoUrl: string; 
}){
        this.id = data.id;
        this.name = data.name;
        this.type = data.type;
        this.age = data.age;
        this.price= data.price;
        this.photoUrl = data.photoUrl;
        
    }
  }
  