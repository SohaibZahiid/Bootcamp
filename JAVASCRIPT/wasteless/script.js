async function getProducts() {
  await axios.get("http://localhost:8080/api/products")
    .then(res => {
      products = res.data;
      console.log(products);
    })
    .catch(error => {
      console.error('Error fetching products:', error);
    });
}

async function getStores() {
  await axios.get("http://localhost:8080/api/stores")
    .then(res => {
      users = res.data;
      console.log(users);
      displayMarkers(users);
    })
    .catch(error => {
      console.error('Error fetching stores:', error);
    });
}

async function displayMarkers(stores) {
  await getProducts(); // Fetch the products before displaying markers

  var map = L.map('map').setView([41.3586, 2.1009], 13);

  L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png').addTo(map);

  // Function to geocode an address and add a marker to the map
  function geocodeAddress(store) {
    var geocodeUrl = 'https://nominatim.openstreetmap.org/search?format=json&q=' + encodeURIComponent(store.address);

    axios.get(geocodeUrl)
      .then(function (response) {
        if (response.data.length > 0) {
          var lat = response.data[0].lat;
          var lon = response.data[0].lon;

          // Find products for this store
          var storeProducts = products.filter(product => product.user === store.id);
          var popupContent = store.name + "<br>" + store.address + "<br>";

          // Add products to the popup content
          if (storeProducts.length > 0) {
            popupContent += "<br>Products:<ul>";
            storeProducts.forEach(product => {
              popupContent += "<li>" + product.foodName + "</li>";
            });
            popupContent += "</ul>";
          } else {
            popupContent += "<br>No products available.";
          }

          L.marker([lat, lon]).addTo(map).bindPopup(popupContent).openPopup();
        } else {
          alert('Address not found for ' + store.name);
        }
      })
      .catch(function (error) {
        console.error(error);
      });
  }

  // Loop through the stores array and add markers to the map
  for (var i = 0; i < stores.length; i++) {
    geocodeAddress(stores[i]);
  }
}

getStores();
