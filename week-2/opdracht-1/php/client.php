<?php

$url = "http://localhost:8080/opdracht_1_war_exploded/MainService?WSDL";
$client = new SoapClient($url, array("trace" => 1, "exception" => 0)); 

$result = $client->__soapCall("getStudent", array(
	"getStudent" => array(
		"naam" => "Peter"
	)
));

print_r($result);