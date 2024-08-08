const mongoose = require('mongoose');

const connectDB = async () => {

    const conn = await mongoose.connect(process.env.MONGO_URI,
    {
        //useNewUrlParser: true,
       // useCreateIndex: true,
        //useFindModify:false,
        //useUnifieldToplogy:true
    });

    console.log(`MongoDB connected: $(conn.connection.host)`.cyan.bold)
}
module.exports = connectDB;

