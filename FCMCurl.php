<?php
    // API access key from Google API's Console
    define('API_ACCESS_KEY','***************');

    $url = 'https://fcm.googleapis.com/fcm/send';

    // prepare the message
         $msg = array( 
            'message'   => "Test Message",
            'nfeed'     => "Test Nfeed Data",
            'vibrate'   => 1,
            'sound'     => 1
         );

         $notification = array( 
            'title'     => "Test Title"
         );

         $fields = array( 
             //'to' => 'YOUR_DEVICE_TOKEN', //Single Device
            'registration_ids' => $registrationIds, //Array of Devices
            'notification' => $notification,
            'data' => $msg
         );

         $headers = array( 
            'Authorization: key='.API_ACCESS_KEY, 
            'Content-Type: application/json'
         );

         $ch = curl_init();
         curl_setopt( $ch,CURLOPT_URL,$url);
         curl_setopt( $ch,CURLOPT_POST,true);
         curl_setopt( $ch,CURLOPT_HTTPHEADER,$headers);
         curl_setopt( $ch,CURLOPT_RETURNTRANSFER,true);
         curl_setopt( $ch,CURLOPT_SSL_VERIFYPEER,false);
         curl_setopt( $ch,CURLOPT_POSTFIELDS,json_encode($fields));
         $result = curl_exec($ch);
         curl_close($ch);
?>
