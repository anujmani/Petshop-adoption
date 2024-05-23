export  class Product {
    static find(arg0: (pet: any) => boolean): Product | undefined {
      throw new Error('Method not implemented.');
    }
    productId: number | undefined;
    name: string | undefined;
    description: string | undefined;
    picture: string;
    price: number| undefined;
  
    constructor(data: {
      price: number | undefined;
      productId: number | undefined;
      name: string | undefined;
      description: string| undefined;
      picture: string;
    }) {
      this.productId = data.productId;
      this.name = data.name;
      this.price = data.price;
      this.description = data.description;
      this.picture = data.picture;
    }
  }
  