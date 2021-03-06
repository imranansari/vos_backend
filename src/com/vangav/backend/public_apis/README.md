
> **why?** fetching data from public apis is necessary in many scenarios like: aggregating topic-specific news from various news agencies, getting member data from facebook/twitter/google/..., integrating other services inyour app (weather info, public transportation, ...)

# public apis

+ this package handles requesting information from [facebook graph api](https://developers.facebook.com/docs/graph-api) and [car2go api](https://github.com/car2go/openAPI); to add other service's apis (e.g.: [instagram api](https://any-api.com/instagram_com/instagram_com/docs/API_Description)), it's recommended to use vangav backend's [client generator](https://github.com/vangav/vos_backend/tree/master/src/com/vangav/backend/backend_client_java)

## [facebook](https://github.com/vangav/vos_backend/tree/master/src/com/vangav/backend/public_apis/facebook)

+ facilitates querying [facebook graph api](https://developers.facebook.com/docs/graph-api) for user-info (pictures, fields, edges, ...) synchronously/asynchronously

### structure

| pkg/class | explanantion |
| --------- | ------------ |
| [FacebookGraph](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/FacebookGraph.java) | is the main class to deal with to fetch data from facebook graph; using it is explained in details in the following section |
| [FacebookGraphApiField](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/json/fields/FacebookGraphApiField.java) | is the parent class for all facebook graph's field-response |
| [FacebookGraphApiFieldType](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/json/fields/FacebookGraphApiFieldType.java) | is an enum representing all facebook graph's fields |
| [fields](https://github.com/vangav/vos_backend/tree/master/src/com/vangav/backend/public_apis/facebook/json/fields) | contains all the classes/packages representing facebook graph's fields-json-response like: [`favorite_athletes`](https://github.com/vangav/vos_backend/tree/master/src/com/vangav/backend/public_apis/facebook/json/fields/favorite_athletes), [`Email`](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/json/fields/Email.java), [`Name`](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/json/fields/Name.java), ... |
| [edge](https://github.com/vangav/vos_backend/tree/master/src/com/vangav/backend/public_apis/facebook/json/edges/edge) | has the parent class [FacebookGraphApiEdge](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/json/edges/edge/FacebookGraphApiEdge.java) for all facebook graph's edges in addition to the static elements in each edge-response like [Paging](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/json/edges/edge/Paging.java) |
| [FacebookGraphApiEdgeType](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/json/edges/FacebookGraphApiEdgeType.java) | is an enum re[resenting all facebook graph's edges |
| [edges](https://github.com/vangav/vos_backend/tree/master/src/com/vangav/backend/public_apis/facebook/json/edges) | contains all packages representing facebook graph's edges-json-respone like: [`friends`](https://github.com/vangav/vos_backend/tree/master/src/com/vangav/backend/public_apis/facebook/json/edges/friends), [`movies`](https://github.com/vangav/vos_backend/tree/master/src/com/vangav/backend/public_apis/facebook/json/edges/movies), [`music`](https://github.com/vangav/vos_backend/tree/master/src/com/vangav/backend/public_apis/facebook/json/edges/music), ... |
| [BadRequestResponse](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/json/BadRequestResponse.java) and [BadRequestResponseError](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/json/BadRequestResponseError.java) | represent facebook graph's bad response (http status code `400`) json response |
| [ErrorResponse](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/json/ErrorResponse.java) | represents facebook graph's response for all http status code other than success `200` and badrequest `400` |

### [FacebookGraph](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/FacebookGraph.java)

+ following is an explanation of the provided features

| method | explanation |
| ------ | ----------- |
| [getUserId](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/FacebookGraph.java#L238) | returns user's facebook numeric id |
| [getProfilePictureSync](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/FacebookGraph.java#L268) and [getProfilePictureAsync](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/FacebookGraph.java#L283) | returns profile picture |
| [getPicturesSync](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/FacebookGraph.java#L422) and [getPicturesAsync](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/FacebookGraph.java#L439) | returns requested pictures (e.g.: from an album) |
| [getFieldsSync](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/FacebookGraph.java#L622) and [getFieldsAsync](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/FacebookGraph.java#L641) | returns requested fields like: [`favorite_athletes`](https://github.com/vangav/vos_backend/tree/master/src/com/vangav/backend/public_apis/facebook/json/fields/favorite_athletes), [`Email`](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/json/fields/Email.java), [`Name`](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/json/fields/Name.java), ... |
| [getEdgesSync](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/FacebookGraph.java#L880) and [getEdgesAsync](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/facebook/FacebookGraph.java#L903) | returns requested edges like: [`friends`](https://github.com/vangav/vos_backend/tree/master/src/com/vangav/backend/public_apis/facebook/json/edges/friends), [`movies`](https://github.com/vangav/vos_backend/tree/master/src/com/vangav/backend/public_apis/facebook/json/edges/movies), [`music`](https://github.com/vangav/vos_backend/tree/master/src/com/vangav/backend/public_apis/facebook/json/edges/music), ... |

### usage template

```java
  // init Facebook Graph API
  // init with user's facebook access token
  FacebookGraph facebookGraph =
    new FacebookGraph("fb_access_token");
  
  // following are examples for some of the avaialble features
  
  // get profile picture synchronously with width = 512 pixels
  String profilePictureSync =
    facebookGraph.getProfilePictureSync(512);

  // get profile picture asynchronously with width = 512 pixels

  String profilePictureAsyncTrackingId =
    facebookGraph.getProfilePictureAsync(512);

  // do other operations while the profile picture is being fetched ...

  String profilePictureAsync =
    facebookGraph.getProfilePictureAsync(
      profilePictureAsyncTrackingId);
  
  // get fields synchronously (favorite athletes and birthday)

  Map<
    FacebookGraphApiFieldType,
    Pair<FacebookApiResponseStatus, RestResponseJson> > fieldsSync =
    facebookGraph.getFieldsSync(
      FacebookGraphApiFieldType.FAVORITE_ATHLETES,
      FacebookGraphApiFieldType.BIRTHDAY);
    
  if (fieldsSync
        .get(FacebookGraphApiFieldType.FAVORITE_ATHLETES)
        .getFirst() == FacebookApiResponseStatus.SUCCESS) {
  
    FavoriteAthletes favoriteAthletes =
      (FavoriteAthletes)fieldsSync
        .get(FacebookGraphApiFieldType.FAVORITE_ATHLETES)
        .getSecond();
  } else if (fieldsSync
               .get(FacebookGraphApiFieldType.FAVORITE_ATHLETES)
               .getFirst() == FacebookApiResponseStatus.BAD_REQUEST) {
  
    BadRequestResponse favoriteAthletesBadRequestResponse =
      (BadRequestResponse)fieldsSync
        .get(FacebookGraphApiFieldType.FAVORITE_ATHLETES)
        .getSecond();
  } else {

    ErrorResponse favoriteAthletesErrorResponse =
      (ErrorResponse)fieldsSync
        .get(FacebookGraphApiFieldType.FAVORITE_ATHLETES)
        .getSecond();
  }

  // the same goes for BIRTHDAY field and any other fields

  // getting edges is similar to getting fields
```

### usage examples

+ in [instagram / HandlerLoginFacebook: `processRequest`](https://github.com/vangav/vos_instagram/blob/master/app/com/vangav/vos_instagram/controllers/login_facebook/HandlerLoginFacebook.java#L140)

```java
  // get user's facebook id
  FacebookGraph facebookGraph =
    new FacebookGraph(requestLoginFacebook.fb_access_token);

  String facebookId = facebookGraph.getUserId();
  
  // get user's info from facebook
      
  // query Facebook Graph API for name
  Map<
    FacebookGraphApiFieldType,
    Pair<Integer, RestResponseJson> > facebookGraphApiResponse =
    facebookGraph.getFieldsSync(FacebookGraphApiFieldType.NAME);

  // error communicating with Facebook Graph API?
  if (facebookGraphApiResponse.get(
        FacebookGraphApiFieldType.NAME).getFirst() !=
        HttpURLConnection.HTTP_OK) {

    throw new CodeException(
      422,
      1,
      "Couldn't get user's name from Facebook Graph API. "
        + "Facebook access token ["
        + requestLoginFacebook.fb_access_token
        + "], request issued from device_token ["
        + requestLoginFacebook.device_token
        + "]. Http Status code ["
        + facebookGraphApiResponse.get(
            FacebookGraphApiFieldType.NAME).getFirst()
        + "], response ["
        + facebookGraphApiResponse.get(
            FacebookGraphApiFieldType.NAME).getSecond().toString()
        + "]",
      ExceptionClass.COMMUNICATION);
  }

  // extract name field
  Name nameField =
    ((Name)facebookGraphApiResponse.get(
      FacebookGraphApiFieldType.NAME).getSecond() );

  // get name
  String name = nameField.name;

  // get user's Facebook profile picture
  String profilePicture =
    facebookGraph.getProfilePictureSync(
      Constants.kFacebookProfilePictureDimension);
```

+ in [instagram / HandlerUpdateFacebookInfo: `processRequest`](https://github.com/vangav/vos_instagram/blob/master/app/com/vangav/vos_instagram/controllers/update_facebook_info/HandlerUpdateFacebookInfo.java#L117)

```java
  // authenticate Facebook's access token
  FacebookAuthInl.validateFacebookAccessToken(
    requestUpdateFacebookInfo.fb_access_token,
    Constants.kFacebookAppId);

  // get user's facebook id
  FacebookGraph facebookGraph =
    new FacebookGraph(requestUpdateFacebookInfo.fb_access_token);

  String facebookId = facebookGraph.getUserId();

  // get user's info from facebook

  // get user's Facebook profile picture
  String profilePicture =
    facebookGraph.getProfilePictureSync(
      Constants.kFacebookProfilePictureDimension);
```

## [car2go](https://github.com/vangav/vos_backend/tree/master/src/com/vangav/backend/public_apis/car2go)

+ facilitates fetching data from car2go api synchronously/asynchronously

### structure

| class/package | explanation |
| ------------- | ----------- |
| [Car2GoApi](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/car2go/Car2GoApi.java) | is the main entry point for fetching data from car2go api |
| [LocationType](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/car2go/LocationType.java) | is an enum representing the locations where car2go operates |
| [json](https://github.com/vangav/vos_backend/tree/master/src/com/vangav/backend/public_apis/car2go/json) | has the mapping classes for the json response per car2go api's public functions |
| [ErrorResponse](https://github.com/vangav/vos_backend/blob/master/src/com/vangav/backend/public_apis/car2go/ErrorResponse.java) | in case car2go api returned a status code other than HTTP_OK (200), this class holds the error response as shown in the following example |

### usage template

```java
  // init car2go API
  Car2GoApi car2GoApi = new Car2GoApi("my_api_key");

  // e.g.: get vehicles synchronously in Seattle and Roma
  Map<LocationType, Pair<Boolean, RestResponseJson> > vehiclesSync =
    car2GoApi.getEdgeSync(
      EdgeType.VEHICLES,
      LocationType.SEATTLE,
      LocationType.ROMA);
    
  // get Roma's vehicles

  if (vehiclesSync.get(LocationType.ROMA).getFirst() == true) {

    Vehicles romaVehicles =
      (Vehicles)vehiclesSync.get(LocationType.ROMA).getSecond();
  } else {

    ErrorResponse romaVehiclesErrorResponse =
      (ErrorResponse)vehiclesSync.get(LocationType.ROMA).getSecond();
  }
```

# exercise

> what's the recommended way to add other service's apis (e.g.: [instagram api](https://any-api.com/instagram_com/instagram_com/docs/API_Description))?

# next tutorial -> [push notifications](https://github.com/vangav/vos_backend/tree/master/src/com/vangav/backend/push_notifications)
> handles building and sending apple and android notifications

# share

[![facebook share](https://www.prekindle.com/images/social/facebook.png)](https://www.facebook.com/sharer/sharer.php?u=https%3A//github.com/vangav/vos_backend)  [![twitter share](http://www.howickbaptist.org.nz/wordpress/media/twitter-64-black.png)](https://twitter.com/home?status=vangav%20backend%20%7C%20build%20big%20tech%2010x%20faster%20%7C%20https%3A//github.com/vangav/vos_backend)  [![pinterest share](http://d7ab823tjbf2qywyt3grgq63.wpengine.netdna-cdn.com/wp-content/themes/velominati/images/share_icons/pinterest-black.png)](https://pinterest.com/pin/create/button/?url=https%3A//github.com/vangav/vos_backend&media=https%3A//scontent-mad1-1.xx.fbcdn.net/v/t31.0-8/20645143_1969408006608176_5289565717021239224_o.png?oh=acf20113a3673409d238924cfec648d2%26oe=5A3414B5&description=)  [![google plus share](http://e-airllc.com/wp-content/themes/nebula/images/social_black/google.png)](https://plus.google.com/share?url=https%3A//github.com/vangav/vos_backend)  [![linkedin share](http://e-airllc.com/wp-content/themes/nebula/images/social_black/linkedin.png)](https://www.linkedin.com/shareArticle?mini=true&url=https%3A//github.com/vangav/vos_backend&title=vangav%20backend%20%7C%20build%20big%20tech%2010x%20faster&summary=&source=)

# free consulting

[![vangav's consultant](http://www.footballhighlights247.com/images/mobile-share/fb-messenger-64x64.png)](https://www.facebook.com/mustapha.abdallah)
