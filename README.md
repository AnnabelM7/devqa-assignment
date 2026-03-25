# 2026 DevQA Engineer internship assignment

## Description

This project contains an automated test for the Playtech People website.

The test does the following:

* Opens https://www.playtechpeople.com
* Finds how many teams there are and lists them
* Gets research areas from the "Who we are" section
* Finds job links in Estonia (Tartu and Tallinn)
* Saves results into a `results.txt` file
* Closes the browser

---

## How to run

1. Make sure you have:

   * Java installed
   * Chrome browser
   * ChromeDriver

2. Run the test class:

```
PlaytechTest
```

---

## Output

After running the test, a file called `results.txt` will be created.

There is also a `sample-results.txt` file in the repository which shows an example output.
*Note: Results can change because the website content changes.*

---

## Notes

* There is a known mismatch between team count and visible cards on the website
