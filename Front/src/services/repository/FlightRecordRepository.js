import axios from 'axios'

class FlightRecordRepository {
    getAll() {}

    save(flightRecord) {
        axios
            .post('http://192.168.1.30:9090/api/flight-record', flightRecord)
            .then((res) => {
                console.log(res)
            })
            .catch((err) => {
                console.log(err)
            })
    }
}

export default FlightRecordRepository
