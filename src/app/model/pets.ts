export  class Pet {
  static find(arg0: (pet: any) => boolean): Pet | undefined {
    throw new Error('Method not implemented.');
  }
  petsId: number | undefined;
  name: string | undefined;
  type: string | undefined;
  petDescription: string | undefined;
  age: number | undefined;
  reason: string | undefined;
  picture: string;

  constructor(data: {
    price: number | undefined;
    petsId: number | undefined;
    name: string | undefined;
    type: string | undefined;
    age: number | undefined;
    picture: string;
    reason: string | undefined;
  }) {
    this.petsId = data.petsId;
    this.name = data.name;
    this.type = data.type;
    this.age = data.age;
    this.picture = data.picture;
    this.reason = data.reason;
  }
}
