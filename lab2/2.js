class Flower{
	constructor(name, freshness, stemLength, cost) {
    this.name = name;
    this.freshness = freshness;
    this.stemLength = stemLength;
    this.cost = cost;
  }
}

class Rose extends Flower {
  constructor(freshness, stemLength, cost) {
    super("Роза", freshness, stemLength, cost);
  }
}

class Tulip extends Flower {
  constructor(freshness, stemLength, cost) {
    super("Тюльпан", freshness, stemLength, cost);
  }
}

class Lily extends Flower {
  constructor(freshness, stemLength, cost) {
    super("Лилия", freshness, stemLength, cost);
  }
}

let rose = new Rose(3, 5, 5)
let tulip = new Tulip(2, 3, 4)
let lily = new Rose(4, 2, 3)

class Accesories{
	constructor(name, cost) {
    this.name = name;
    this.cost = cost;
  }
}

let accessory = new Accesories('accessory', 4)

class Bouquet {
  constructor() {
    this.flowers = [];
    this.accessories = [];
		this.totalCost = 0
  }

  addFlower(flower) {
    this.flowers.push(flower);
  }

  addAccessory(accessory) {
    this.accessories.push(accessory);
  }

  calculateCost() {
    for (let flower of this.flowers) {
      this.totalCost += flower.cost;
    }
    for (let accessory of this.accessories) {
      this.totalCost += accessory.cost;
    }
  }
	sort() {
		this.flowers.sort((a, b) => b.freshness - a.freshness);
	}
	findFlowerInCalorieRange(min, max) {
		for (let flower of this.flowers) {
			if (flower.stemLength >= min && flower.stemLength <= max) {
				console.log(flower);
			}
		}
	}
	
}

let bouquet = new Bouquet
bouquet.addFlower(rose)
bouquet.addFlower(lily)
bouquet.addFlower(tulip)
bouquet.addAccessory(accessory)

bouquet.calculateCost()
bouquet.sort()
console.log(bouquet);
// console.log(bouquet.totalCost);

bouquet.findFlowerInCalorieRange(4, 5)
 
