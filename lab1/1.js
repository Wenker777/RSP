class Train {
	constructor(destination, trainNumber, departureTime, commonSeats, coupeSeats, platzkartSeats, luxSeats) {
		this.destination = destination;
		this.trainNumber = trainNumber;
		this.departureTime = departureTime;
		this.commonSeats = commonSeats;
		this.coupeSeats = coupeSeats;
		this.platzkartSeats = platzkartSeats;
		this.luxSeats = luxSeats;
	}

	get destination() {
		return this._destination;
	}
	set destination(value) {
		this._destination = value;
	}
	get trainNumber() {
		return this._trainNumber;
	}

	set trainNumber(value) {
		this._trainNumber = value;
	}
	get departureTime() {
		return this._departureTime;
	}

	set departureTime(value) {
		this._departureTime = value;
	}
	get commonSeats() {
		return this._commonSeats;
	}

	set commonSeats(value) {
		this._commonSeats = value;
	}

	get coupeSeats() {
		return this._coupeSeats;
	}
	set coupeSeats(value) {
		this._coupeSeats = value;
	}
	get platzkartSeats() {
		return this._platzkartSeats;
	}

	set platzkartSeats(value) {
		this._platzkartSeats = value;
	}

	get luxSeats() {
		return this._luxSeats;
	}

	set luxSeats(value) {
		this._luxSeats = value;
	}

	toString() {
		return `Train ${this.trainNumber} to ${this.destination}, departs at ${this.departureTime}, Total Seats: ${this.commonSeats}, Coupe: ${this.coupeSeats}, Platzkart: ${this.platzkartSeats}, Lux: ${this.luxSeats}`;
	}
	hashCode() {
		return this.trainNumber;
	}
}


class TrainSystem {
	constructor() {
		this.trains = [];
	}

	addTrain(train) {
		this.trains.push(train);
	}

	getTrainsToDestination(destination) {
		return this.trains.filter(train => train.destination === destination);
	}

	getTrainsToDestinationAfterTime(destination, hour) {
		return this.trains.filter(train => train.destination === destination && train.departureTime.split(':')[0] > hour);
	}

	getTrainsWithGeneralSeatsUntilDestination(destination) {
		return this.trains.filter(train => train.destination === destination && train.commonSeats > 0);
	}
	displayTrains(trains) {
		if (trains.length === 0) {
			console.log('No trains found.');
		} else {
			trains.forEach(train => console.log(train.toString()));
		}
	}
}
const trainSystem = new TrainSystem();

trainSystem.addTrain(new Train('Simferopol', '001', '12:30', 100, 50, 30, 20));
trainSystem.addTrain(new Train('Simferopol', '001', '10:30', 0, 50, 30, 20));
trainSystem.addTrain(new Train('Kerch', '002', '14:15', 80, 30, 40, 10));


// a) Список поездов, следующих до заданного пункта назначения
// trainSystem.displayTrains(trainSystem.getTrainsToDestination('Simferopol'));

// b) Список поездов, следующих до заданного пункта назначения и отправляющихся после заданного часа
// trainSystem.displayTrains(trainSystem.getTrainsToDestinationAfterTime('Simferopol', '11'));

// c) Список поездов, отправляющихся до заданного пункта назначения и имеющих общие места
trainSystem.displayTrains(trainSystem.getTrainsWithGeneralSeatsUntilDestination('Simferopol'));
