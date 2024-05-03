function navigate(page) {
    window.location.href = page;
}

function fetchEvents() {
    fetch('/api/events')
        .then(response => response.json())
        .then(events => {
            const eventsList = document.getElementById('events-list');
            eventsList.innerHTML = '';
            events.forEach(event => {
                const eventDiv = document.createElement('div');
                eventDiv.className = 'event';
                eventDiv.innerHTML = `
                    <h2>${event.name}</h2>
                    <p>Location: ${event.location}</p>
                    <p>Date: ${event.date}</p>
                    <button onclick="navigate('event.html?id=${event.id}')">More Details</button>
                `;
                eventsList.appendChild(eventDiv);
            });
        })
        .catch(error => console.error('Error fetching events:', error));
}

function fetchEventDetails() {
    const urlParams = new URLSearchParams(window.location.search);
    const eventId = urlParams.get('id');

    if (eventId) {
        fetch(`/api/events/${eventId}`)
            .then(response => response.json())
            .then(event => {
                const eventDetails = document.getElementById('event-details');
                eventDetails.innerHTML = `
                    <h2>${event.name}</h2>
                    <p>Location: ${event.location}</p>
                    <p>Date: ${event.date}</p>
                    <p>Description: ${event.description}</p>
                    <button onclick="registerForEvent()">Register for this Event</button>
                `;
            })
            .catch(error => console.error('Error fetching event details:', error));
    } else {
        console.error('Event ID not found');
    }
}
