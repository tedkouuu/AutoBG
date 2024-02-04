function showWelcomeMessage() {
    if (sessionStorage.getItem('welcomeMessageShown') == null) {
        alert('Welcome to AutoBG 🚗\n\nAttention, customers: Expert advice - if something is not working, try turning it off and on again! 😄');
        sessionStorage.setItem('welcomeMessageShown', 'true');
    }
}

document.addEventListener('DOMContentLoaded', showWelcomeMessage);