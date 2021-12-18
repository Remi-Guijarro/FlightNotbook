import { createClient } from '@supabase/supabase-js'

class DatabaseService {
    constructor() {
        this.driver = createClient(
            'https://iplvthtoszhaiqijttzs.supabase.co',
            'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlIjoiYW5vbiIsImlhdCI6MTYyNzQxNjczNywiZXhwIjoxOTQyOTkyNzM3fQ.mtrPNUuqH8FQnf6FPmZkEpKp86c3_6lHuVfUcm3-FpI'
        )
    }

    getDriver() {
        return this.driver
    }
}

export default DatabaseService
