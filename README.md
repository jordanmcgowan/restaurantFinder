
# restaurantFinder

This is an app that simply queries the Google Places API based on the location of the user. It will find the first 20 results for "restaurants" within 5000m. It will allow the user to visit a simple Details page that showcases some additional information off including the ability to launch their navigation app of choice to get directions there. Some pleasant bonus features include:
* The ability to favorite locations
* A map view showcasing locations of the items on the list screen
* Keyword search for all your favorite cuisines, like Ethiopian food!

### Running the app
In order to use the application locally (built and deployed to your device), you'll need to app the API Key to your `local.properties` file. The attribute should be `apiKey={your_key}`. All other dependencies should be resolved naturally and the app should run correctly out of the box 

### Technical Specs
`restraurantFinder` uses some of the latest and greatest Android technologies to provider the user a snappy interface and the developer an easier and cleaner implementation.

#### Networking
API calls are made with the help of OkHttp3 and Retrofit2. Successful requests are parsed by Moshi and pushed through to consumers via `LiveData`.

#### Views
The app is built on a standard MVVM template with the VM passing `LiveData` through to a Fragment's `viewLifecycleOwner` that subsequently update views with the data received. `State` and `Action` sealed classes handle the operations of the experience. In the case of `MainFragment`, we have a `RecyclerView` powered by the `SuggestionAdapter`. The Adapter can communicate with the Fragment via a type-aliased ActionHandler.

Beyond the standard views, the application also houses a basic `SupportMapFragment`. A lightweight model object is passed through the `Bundle` to allow the `MapFragment` to avoid any network calls. "Custom" map marker listeners allow the user to navigate to the `DetailFragment`

#### Dependency Injection
The `PlacesManager` (the central networking class) is provided to all `ViewModels` via Dagger. The `PlacesManagerModule` will create all the necessary dependencies and open the door for any class that may need to `@Inject` them.

#### Data Persistance
One of the features within the application, favorites, is powered almost entirely by a `Room` database. Dagger provides the `Dao` to the rest of the project where a simple `Repository` allows DB interaction. The DB is keyed off of the unique `place_id` supplied by the service and allows for all screens to determine if an item is a favorite or not. User based updates are immediate and every screen should reflect the proper favorite status when properly implemented. 