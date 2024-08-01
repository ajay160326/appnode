const readline = require('readline-sync');
const axios = require('axios');

const baseURL = 'http://localhost:3000';

async function createDocument() {
    const data = readline.question("Enter document data (as JSON): ");
    try {
        const response = await axios.post(`${baseURL}/create`, JSON.parse(data));
        console.log('Document inserted with ID:', response.data.insertedId);
    } catch (error) {
        console.error('Error:', error.response.data.error);
    }
}

async function readDocuments() {
    try {
        const response = await axios.get(`${baseURL}/read`);
        console.log('Documents:', response.data);
    } catch (error) {
        console.error('Error:', error.response.data.error);
    }
}

async function updateDocument() {
    const id = readline.question("Enter document ID to update: ");
    const data = readline.question("Enter new data (as JSON): ");
    try {
        const response = await axios.put(`${baseURL}/update/${id}`, JSON.parse(data));
        console.log('Update result:', response.data);
    } catch (error) {
        console.error('Error:', error.response.data.error);
    }
}

async function deleteDocument() {
    const id = readline.question("Enter document ID to delete: ");
    try {
        const response = await axios.delete(`${baseURL}/delete/${id}`);
        console.log('Delete result:', response.data);
    } catch (error) {
        console.error('Error:', error.response.data.error);
    }
}

function menu() {
    while (true) {
        console.log("\nMongoDB CRUD Operations Menu:");
        console.log("1. Create Document");
        console.log("2. Read Documents");
        console.log("3. Update Document");
        console.log("4. Delete Document");
        console.log("5. Exit");
        const choice = readline.question("Enter your choice: ");
        
        if (choice === '1') {
            createDocument();
        } else if (choice === '2') {
            readDocuments();
        } else if (choice === '3') {
            updateDocument();
        } else if (choice === '4') {
            deleteDocument();
        } else if (choice === '5') {
            console.log("Exiting...");
            process.exit();
        } else {
            console.log("Invalid choice. Please select a valid option.");
        }
    }
}

menu();
