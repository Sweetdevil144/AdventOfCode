package main

import (
	"encoding/json"
	"fmt"
	"log"
	"os"
	"strconv"
)

type GameData struct {
	Red   int `json:"red"`
	Blue  int `json:"blue"`
	Green int `json:"green"`
}

var value bool

func main() {
	var sum = 0

	// Define a variable of type map[string][]GameData
	var data map[string][]GameData
	// Open the JSON file
	file, err := os.Open("data.json")
	if err != nil {
		log.Fatal(err)
	}
	defer file.Close()

	// Create a new JSON decoder
	decoder := json.NewDecoder(file)

	// Decode the JSON data from the file into the map
	err = decoder.Decode(&data)
	if err != nil {
		log.Fatal(err)
	}

	// Now you can use the data
	//fmt.Println(data["1"])
	for i := 1; i <= 100; i++ {
		str := strconv.Itoa(i)
		if getResult(data, str) {
			sum += i
		}
	}
	fmt.Println(sum)
}

func getResult(data map[string][]GameData, s string) bool {
	for j := 0; j < len(data[s]); j++ {
		value = getValueOne(data[s][j].Red, data[s][j].Blue, data[s][j].Green)
		if !value {
			return false
		}
	}
	return true
}

func getValueOne(red, blue, green int) bool {
	if red <= 12 && blue <= 14 && green <= 13 {
		return true
	} else {
		return false
	}
}
