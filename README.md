# restaurantFinder

|List|Detail|Map|
|---|---|---|
|![Screenshot_20211006-164845](https://user-images.githubusercontent.com/10715645/136288530-c5df123d-0f00-410a-92a4-9b1df38aa87a.png)|![Screenshot_20211006-164851](https://user-images.githubusercontent.com/10715645/136288525-e45584f3-0030-4643-b78d-8a0fe7f7dd52.png)|![Screenshot_20211006-164903](https://user-images.githubusercontent.com/10715645/136288518-965ebbc6-abca-45c7-9714-755d1886fbe4.png)|

This is an app that simply queries the Google Places API based on the location of the user. It will find the first 20 results for "restaurants" within 5000m. It will allow the user to visit a simple Details page that showcases some additional information off including the ability to launch their navigation app of choice to get directions there. Some pleasant bonus features include:
* The ability to favorite locations
* A map view showcasing locations of the items on the list screen
* Keyword search for all your favorite cuisines, like Ethiopian food!
* Support for light and dark mode

## Running the app
The application should run out of the box if you grab the apk from the releases tab, but if you're running this locally you'll need to ensure you add a Google API to your `local.properties` - it should look like `apiKey={your_key}`. Building and installing locally should then launch the app for you!

### Technical Specs
`restraurantFinder` uses some of the latest and greatest Android technologies to provider the user a snappy interface and the developer an easier and cleaner implementation.

#### Networking
API calls are made with the help of OkHttp3 and Retrofit2. Successful requests are parsed by Moshi and pushed through to consumers via `LiveData`.

#### Views
The app is built on a standard MVVM template with the VM passing `LiveData` through to a Fragment's `viewLifecycleOwner` that subsequently update views with the data received. `State` and `Action` sealed classes handle the operations of the experience. In the case of `MainFragment`, we have a `RecyclerView` powered by the `SuggestionAdapter`. The Adapter can communicate with the Fragment via a type-aliased ActionHandler.

Beyond the standard views, the application also houses a basic `SupportMapFragment`. A lightweight model object is passed through the `Bundle` to allow the `MapFragment` to avoid any network calls. "Custom" map marker listeners allow the user to navigate to the `DetailFragment`

#### Dependency Injection
The `PlacesManager` (the central networking class) is provided to all `ViewModels` via Dagger. The `PlacesManagerModule` will create all the necessary dependencies and open the door for any class that may need to `@Inject` them.

#### Data Persistence
One of the features within the application, favorites, is powered almost entirely by a `Room` database. Dagger provides the `Dao` to the rest of the project where a simple `Repository` allows DB interaction. The DB is keyed off of the unique `place_id` supplied by the service and allows for all screens to determine if an item is a favorite or not. User based updates are immediate and every screen should reflect the proper favorite status when properly implemented.

#### Dev Tools
[Flipper](https://github.com/facebook/flipper) had been a part of the bundle until 10/6 when I started to experience the issue found [here](https://github.com/facebook/flipper/issues/2213). If you would like to try it out on your own, simply add these dependencies to the app's `build.gradle`:
```
    //Flipper
    debugImplementation 'com.facebook.flipper:flipper:0.113.0'
    debugImplementation 'com.facebook.soloader:soloader:0.10.1'
    releaseImplementation 'com.facebook.flipper:flipper-noop:0.113.0'
```

and these within `onCreate()` in `MyApp.kt`: 
```kotlin
        SoLoader.init(this, false)

        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            val client = AndroidFlipperClient.getInstance(this)
            val descriptorMapping = DescriptorMapping.withDefaults()
            client.addPlugin(InspectorFlipperPlugin(this, descriptorMapping))
            client.addPlugin(DatabasesFlipperPlugin(this))

            client.start()
        }
```

#### Known Issues
* At times, tapping the Favorite icon within `MainFragment` is taking the action to show just the favorites in the list. Debugging has proven fruitless...
