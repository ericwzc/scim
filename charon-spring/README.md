### Create User
`curl -v --data '{"schemas":[],"name":{"familyName":"jayawardana","givenName":"vindula"},"userName":"vindula","password":"vindula","emails":[{"value":"vindula@work.com","type":"work"}]}' --header "Content-Type:application/scim+json" http://localhost:8080/scim/v2/Users`


### Update User
`curl -X PUT -v --data '{"schemas":[],"name":{"familyName":"jayawardana","givenName":"vindula"},"userName":"vindula","password":"vindula","emails":[{"value":"vindula@work.com","type":"work"}]}' --header "Content-Type:application/scim+json" http://localhost:8080/scim/v2/Users/b2c0601b-a16c-461c-95a9-ed110fb1938a`


### Delete User
`curl -X DELETE http://localhost:8080/scim/v2/Users/b2c0601b-a16c-461c-95a9-ed110fb1938a`