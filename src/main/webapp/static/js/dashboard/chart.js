// Data
const data = {
    labels: labels,
    datasets: [{
        label: 'Investors',
        data: [12, 19, 3, 5, 2, 3],
        backgroundColor: [
            'rgb(182, 0, 182)'
        ],
        borderColor: [
            'rgb(182, 0, 182)'
        ],
        borderWidth: 1,
    },{
        label: 'Creators',
        data: [10, 9, 13, 6, 12, 4],
        backgroundColor: [
            'rgb(255, 115, 0)'
        ],
        borderColor: [
            'rgb(255, 115, 0)'
        ],
        borderWidth: 1,
    },{
        label: 'Projects',
        data: [15, 18, 1, 8, 10, 5],
        backgroundColor: [
            'rgb(3, 216, 21)'
        ],
        borderColor: [
            'rgb(3, 216, 21)'
        ],
        borderWidth: 1,
    },{
        label: 'Competitions',
        data: [5, 6, 7, 8, 9, 14],
        backgroundColor: [
            'rgb(0, 110, 255)'
        ],
        borderColor: [
            'rgb(0, 110, 255)'
        ],
        borderWidth: 1,
    }]
};

// Config
var config = {
    type: 'line',
    data,
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
};

// Line Chart
const graph1_id =  document.getElementById('chart1').getContext('2d');
const chart1 = new Chart(graph1_id,config);

// Bar Chart
config.type = 'bar'
const graph2_id =  document.getElementById('chart2').getContext('2d');
const chart2 = new Chart(graph2_id,config);


