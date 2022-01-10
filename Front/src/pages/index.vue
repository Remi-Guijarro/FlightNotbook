<template>
    <div class="flex flex-col items-center h-auto p-5 lg:h-auto bg-milk">
        <div
            id="flight-records"
            class="flex-1 bg-milk flex items-center justify-center w-full"
        >
            <div
                v-for="flight in state.flights"
                :key="flight.uiud"
                class="w-full bg-saphire flight-record"
            >
                <div class="flight-element font-title">
                    <img
                        src="/imgs/calendar.png"
                        alt="calendar"
                        width="20"
                        height="20"
                    />
                    <p class="flight-elem-text">
                        {{ convertDate(flight.date) }}
                    </p>
                </div>
                <div class="flight-element font-title">
                    <img
                        src="/imgs/take-off.png"
                        alt="départ"
                        width="20"
                        height="20"
                    />
                    <p class="flight-elem-text">{{ flight.aeroDep }}</p>
                </div>
                <div class="flight-element font-title">
                    <img
                        src="/imgs/land.png"
                        alt="arrivé"
                        width="20"
                        height="20"
                    />
                    <p class="flight-elem-text">{{ flight.aeroArr }}</p>
                </div>
                <div class="flight-element font-title">
                    <img
                        src="/imgs/stopwatch.png"
                        alt="flight time"
                        width="20"
                        height="20"
                    />
                    <p class="flight-elem-text">
                        {{ computeFlightTime(flight.horaDep, flight.horaArr) }}
                    </p>
                </div>
            </div>
        </div>

        <div class="load-more-container">load more</div>
    </div>
</template>

<script>
    import { onMounted, reactive } from 'vue'
    import { useHead } from '@vueuse/head'
    import { NavBar, InputGroup } from '/src/components'
    import axios from 'axios'
    import packageJSON from '/src/../package.json'

    export default {
        components: {
            NavBar,
            InputGroup,
        },

        setup() {
            useHead({
                title: packageJSON.name,
                meta: [
                    {
                        name: 'description',
                        content: packageJSON.description,
                    },
                ],
            })
            onMounted(() => {
                getAllFlightRecord()
            })
            function getAllFlightRecord() {
                // http://localhost:9090/api/flight-record
                axios
                    .get('http://192.168.1.30:9090/api/flight-record')
                    .then((response, error) => {
                        state.flights = response.data
                        console.log(state.flights)
                    })
                    .catch((err) => {
                        console.log(err)
                    })
            }

            function convertDate(inputFormat) {
                function pad(s) {
                    return s < 10 ? '0' + s : s
                }
                let d = new Date(inputFormat)
                return [
                    pad(d.getDate()),
                    pad(d.getMonth() + 1),
                    d.getFullYear(),
                ].join('/')
            }

            function computeFlightTime(horaDep, horaArr) {
                let startDate = returnDateFromTime(horaDep)
                let endDate = returnDateFromTime(horaArr)
                return toHHMM((endDate - startDate) / 1000)
            }

            function returnDateFromTime(time) {
                let hoursMinute = time.split(':')
                let date = new Date()
                date.setHours(hoursMinute[0])
                date.setMinutes(hoursMinute[1])
                return date
            }

            function toHHMM(time) {
                var sec_num = parseInt(time, 10) // don't forget the second param
                var hours = Math.floor(sec_num / 3600)
                var minutes = Math.floor((sec_num - hours * 3600) / 60)
                var seconds = sec_num - hours * 3600 - minutes * 60

                if (hours < 10) {
                    hours = '0' + hours
                }
                if (minutes < 10) {
                    minutes = '0' + minutes
                }
                if (seconds < 10) {
                    seconds = '0' + seconds
                }
                return hours + ':' + minutes
            }

            const state = reactive({
                flights: [],
            })

            return { state, convertDate, computeFlightTime }
        },
    }
</script>

<style scoped>
    #flight-records {
        display: flex;
        flex-direction: column;
    }

    .flight-record {
        border-radius: 10px;
        display: flex;
        flex-direction: row;
        justify-content: space-around;
        padding-top: 15px;
        padding-bottom: 15px;
        margin-bottom: 45px;
    }

    .flight-element img {
        margin: auto;
    }

    .flight-elem-text {
        margin-top: 8px;
        font-size: 0.7em;
        color: white;
    }

    .load-more-container {
        font-size: 0.9em;
        color: #364b5f;
        cursor: pointer;
    }
</style>
