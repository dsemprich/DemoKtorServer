package com.example.repository

import com.example.models.ApiResponse
import com.example.models.Hero
import kotlinx.html.PRE
import org.koin.java.KoinJavaComponent.inject


const val NEXT_PAGE_KEY = "nextPage"
const val PREVIOUS_PAGE_KEY = "prevPage"

class HeroRepositoryImpl: HeroRepository {

    override val heroes: Map<Int, List<Hero>> by lazy {
        mapOf(
            1 to page1,
            2 to page2,
            3 to page3,
            4 to page4,
            5 to page5
        )
    }

    override val page1 = listOf(
        Hero(
            id = 1,
            name = "Starlord",
            image = "/images/starlord-01.jpg",
            about = "Peter Quill was born on Earth, the son of a human mother and an alien father. Plucked from his rural home, he was thrust into a life of roguery and adventure across the stars. Now teamed up with a group called the Guardians of the Galaxy, Peter Quill has been kicking bad guy butts and saving the day under a different moniker: Star-Lord.",
            rating = 5.0,
            power = 98,
            month = "July",
            day = "23rd",
            family = listOf(
                "Meredith Quill",
                "J'Son",
                "Jake",
                "Victoria",
                "Sandy"
            ),
            abilities = listOf(
                "Force Field",
                "Healing Factor",
                "Healing Factor",
                "Superior Marksmanship",
                "Flight"
            ),
            natureTypes = listOf(
                "Lightning",
                "Fire",
                "Wind",
                "Earth",
                "Water"
            )
        ),
        Hero(
            id = 2,
            name = "Gamora",
            image = "/images/gamora-01.jpg",
            about = "After seeing the Zen-Whoberi people nearly completely wiped from existence by the Badoon, Thanos took the lone survivor and decided to turn her into the deadliest woman in the universe. That woman is Gamora, an incredibly adept student in the art of combat, war, and death, who has done both evil and good during her galaxy-wide travels. Among her victories: keeping reality safe alongside Adam Warlock, Infinity Watch, and the Guardians of the Galaxy, her current team-turned-family.",
            rating = 5.0,
            power = 98,
            month = "Oct",
            day = "10th",
            family = listOf(
                "Thanos",
                "Nebula"
            ),
            abilities = listOf(
                "Superhuman Durability",
                "Superhuman Strength",
                "Sword-Fighting",
                "Hand-to-Hand Combat"
            ),
            natureTypes = listOf(
                "Wind",
                "Earth",
                "Lava",
                "Fire"
            )
        ),
        Hero(
            id = 3,
            name = "Groot",
            image = "/images/groot-01.jpg",
            about = "Hailing from the Branch Worlds’ Planet X, Groot is part of a species called Groot, so his name is also the title of his taxonomic classification. From the time he was a sapling, Groot was destined to protect the rights of the downtrodden. He campaigned for the Undergrowth, anthropomorphic animals and fungi who helped maintain Planet X’s ecosystem by performing menial tasks. Groot’s noble campaign drew the rancor of the other Groots and he ended up leaving his home world.",
            rating = 4.5,
            power = 92,
            month = "Mar",
            day = "28th",
            family = listOf(
                "Unknown"
            ),
            abilities = listOf(
                "Healing Factor",
                "Superhuman Strength"
            ),
            natureTypes = listOf(
                "Earth",
                "Water",
                "Fire"
            )
        )
    )
    override val page2 = listOf(
        Hero(
            id = 4,
            name = "Captain America",
            image = "/images/cpt_america-01.jpg",
            about = "From the dark days of world war to the explosive challenges of today, Super-Soldier Captain America stands ready as a shining sentinel of liberty to shield the oppressed and fight for freedom everywhere.",
            rating = 4.9,
            power = 95,
            month = "Mar",
            day = "27th",
            family = listOf(
                "Sarah Rogers",
                "Joseph Rogers"
            ),
            abilities = listOf(
                "Superhuman Agility",
                "Superhuman Stamina",
                "Superhuman Stamina",
                "Superhuman Strength"
            ),
            natureTypes = listOf(
                "Lightning",
                "Wind",
                "Water"
            )
        ),
        Hero(
            id = 5,
            name = "Black Widow",
            image = "/images/black_widow-01.jpg",
            about = "Gifted spy Natasha Romanoff is more than worthy of her moniker, Black Widow. Ruthless, efficient, and exceptionally skilled, Natasha strikes fear into the hearts of her enemies. Although she once operated on the side of evil, her innate heroism allowed her to overcome her upbringing and defect, setting her on a lifelong path of redemption.",
            rating = 4.9,
            power = 95,
            month = "Mar",
            day = "31st",
            family = listOf(
                "Vindiktor",
                "Alexi Shostakov"
            ),
            abilities = listOf(
                "Slowed Aging",
                "Assassin",
                "Superhuman Durability"
            ),
            natureTypes = listOf(
                "Lightning",
                "Wind",
                "Fire"
            )
        ),
        Hero(
            id = 6,
            name = "Hulk",
            image = "hulk-01.jpg",
            about = "Scientist Bruce Banner’s inner turmoil transforms him into the mean, green rage machine called the Hulk.",
            rating = 4.9,
            power = 95,
            month = "Jul",
            day = "25th",
            family = listOf(
                "Rebecca Banner",
                "Brian Banner",
                "Caiera",
                "Elizabeth Betty Ross",
                "Skaar",
                "Jennifer Walters"
            ),
            abilities = listOf(
                "Healing Factor",
                "Superhuman Durability",
                "Superhuman Strength",
                "Size and Shape Alteration",
                "Genius Intelligence"
            ),
            natureTypes = listOf(
                "Lightning",
                "Wind"
            )
        )
    )
    override val page3 = listOf(
        Hero(
            id = 7,
            name = "Thor",
            image = "/images/thor-01.jpg",
            about = "The very skies tremble in his presence. He commands the mystical hammer Mjolnir to protect Asgard and Earth. He is the son of Odin, Prince of Asgard. He is the God of Thunder. He is Thor.",
            rating = 4.2,
            power = 99,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Gaea",
                "Frigga",
                "Odin Borson",
                "Sigyn",
                "Solveig",
                "Loki",
                "Balder",
                "Vidar"
            ),
            abilities = listOf(
                "Berserker Rage",
                "Superhuman Strength",
                "Superhuman Durability",
                "Superhuman Speed",
                "Superhuman Reflexes",
                "Control of Elements",
                "Hand-to-Hand Combat",
                "Sword-Fighting"
            ),
            natureTypes = listOf(
                "Lightning",
                "Wind",
                "Fire"
            )
        ),
        Hero(
            id = 8,
            name = "Valkyrie",
            image = "/images/valkyrie-01.jpg",
            about = "A powerful Asgardian warrior, Valkyrie is a goddess who can sense death, and was selected by Odin to escort the honored slain to Valhalla. On Earth, she was known simply as Samantha Parrington. But after being mystically endowed with the responsibilities, strength, and super human power of the Asgardian Brunnhilde, Parrington became the leader of the team of female cosmic warriors known as the Valkyrior.",
            rating = 4.5,
            power = 96,
            month = "Sep",
            day = "15th",
            family = listOf(
                "Malicia Parrington",
                "Malicia Parrington"
            ),
            abilities = listOf(
                "Superhuman Strength",
                "Superhuman Strength",
                "Heightened Senses",
                "Teleportation",
                "Deathglow Vision"
            ),
            natureTypes = listOf(
                "Lightning",
                "Wind",
                "Fire",
                "Earth",
                "Water"
            )
        ),
        Hero(
            id = 9,
            name = "Heimdall",
            image = "/images/heimdall-01.jpg",
            about = "Heimdall guards Asgard as King Odin's appointed sentry of the Rainbow Bridge known as the Bifrost. Halting all those that would cause harm to his fellow Asgardians, Heimdall stands as the first line of defense against all manner of attacks against his home realm. Duty is paramount to him, even acting at times to keep his own friends and allies from entering Asgard against Odin's orders.",
            rating = 5.0,
            power = 90,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Unknown"
            ),
            abilities = listOf(
                "Slowed Aging",
                "Heightened Senses",
                "Superhuman Strength",
                "Superhuman Durability",
                "Odin Power"
            ),
            natureTypes = listOf(
                "Fire"
            )
        )
    )
    override val page4 = listOf(
        Hero(
            id = 10,
            name = "Captain Marvel",
            image = "cpt_marvel-01.jpg",
            about = "Former Air Force pilot and intelligence agent Carol Danvers pursued her dream of space exploration as a NASA employee, but her life forever changed when she was accidentally transformed into a human-Kree hybrid with extraordinary powers. Now, Carol is the latest warrior to embrace the mantle of Captain Marvel, and she has taken her place as one of the world’s mightiest heroes.",
            rating = 3.9,
            power = 98,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Marie Danvers",
                "Joseph Danvers",
                "Joeseph Danvers Jr."
            ),
            abilities = listOf(
                "Flight",
                "Energy Blasts",
                "Superhuman Durability",
                "Superhuman Strength"
            ),
            natureTypes = listOf(
                "Fire",
                "Lightning",
                "Wind",
                "Water",
                "Earth"
            )
        ),
        Hero(
            id = 11,
            name = "Dr.Strange",
            image = "/images/dr_strange-01.jpg",
            about = "As Earth’s Sorcerer Supreme, Doctor Strange wields arcane spells and mystical artifacts to defend the planet against malevolent threats.",
            rating = 3.4,
            power = 95,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Beverly Strange",
                "Eugene Strange",
                "Donna Strange",
                "Victor Strange",
                "Cela"
            ),
            abilities = listOf(
                "Magic",
                "Martial Artist",
                "Energy Manipulation",
                "Teleportation",
                "Chronokinesis"
            ),
            natureTypes = listOf(
                "Fire",
                "Lightning",
                "Wind",
                "Earth"
            )
        ),
        Hero(
            id = 12,
            name = "Thena",
            image = "/images/thena-01.jpg",
            about = "Thena is a second generation Eternal (evolutionary offshoot of humanity created by experiments performed by the Celestials), being the eldest daughter of Zuras, leader of the Eternals of Earth, and Cybele. Although she has lived for over 4,000 years, Thena is still considered a young woman by Eternal standards. At her birth she was named Azura in honor of her father, Zuras.",
            rating = 4.8,
            power = 99,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Zuras",
                "Cybele",
                "Deborah Ritter",
                "Donald Ritter",
                "Thomas Eliot"
            ),
            abilities = listOf(
                "Sword Fighting",
                "Hand to Hand Fighting"
            ),
            natureTypes = listOf(
                "Unknown"
            )
        )
    )
    override val page5 = listOf(
        Hero(
            id = 13,
            name = "Spiderman",
            image = "/images/spiderman-01.jpg",
            about = "With spider-like abilities, science genius Peter Parker swings above it all as Spider-Man, costumed champion of the innocent who lives and fights with the wisdom of “With Great Power Comes Great Responsibility!",
            rating = 5.0,
            power = 90,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Mary Parker",
                "Richard Parker",
                "Mary Jane Watson-Parker",
                "Anna-May Parker",
                "May Parker-Jameson"
            ),
            abilities = listOf(
                "Superhuman Strength",
                "Superhuman Speed",
                "Superhuman Durability",
                "Healing Factor",
                "Spider-Sense Alert",
                "Wallcrawling"
            ),
            natureTypes = listOf(
                "Unknown"
            )
        ),
        Hero(
            id = 14,
            name = "Ironman",
            image = "/images/ironman-01.jpg",
            about = "Tony Stark is the wealthy son of industrialist and weapons manufacturer Howard Stark and his wife, Maria. Tony grew up a genius with a brilliant mind for technology and inventions and, naturally, followed in his father’s footsteps, inheriting Stark Industries upon his parents’ untimely death. Tony designed many weapons of war for Stark Industries, far beyond what any other company was creating, while living the lifestyle of a bon vivant.",
            rating = 4.5,
            power = 90,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Maria Collins Carbonell Stark",
                "Howard Anthony Walter Stark",
                "Morgan Stark"
            ),
            abilities = listOf(
                "Heightened Senses",
                "Superhuman Strength",
                "Regeneration",
                "Genius Intelligence"
            ),
            natureTypes = listOf(
                "Fire",
                "Earth"
            )
        ),
        Hero(
            id = 15,
            name = "Wanda",
            image = "/images/wanda-01.jpg",
            about = "Although much of the Scarlet Witch’s true origins remain elusive to her thanks to manipulations by others, she can still recall her early days as a child with her twin brother Pietro. The two lived on Wundagore Mountain in Eastern Europe, believing themselves born as mutants to a Romani couple named the Maximoffs. Given the name Wanda, she lived for a short time in childish innocence until local troubles involving her parents separated her and her brother from them and forced her to hide her growing powers.",
            rating = 4.5,
            power = 90,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Magda Eisenhardt",
                "Marya Maximoff",
                "Max Eisenhardt"
            ),
            abilities = listOf(
                "Illumination",
                "Magic",
                "Matter Transmutation",
                "Powers of Life and Death",
                "Probability Alteration",
                "Psychometry Precognition",
                "Mind Control",
                "Healing Factor",
                "Psionics"
            ),
            natureTypes = listOf(
                "Fire",
                "Earth"
            )
        )
    )

    override suspend fun getAllHeroes(page: Int): ApiResponse {
        return ApiResponse(
            success = true,
            message = "ok",
            prevPage = calculatePage(page = page)[PREVIOUS_PAGE_KEY],
            nextPage = calculatePage(page = page)[NEXT_PAGE_KEY],
            heroes = heroes[page]!!
        )
    }

    private fun calculatePage(page: Int): Map<String, Int?> {
        var prevPage: Int? = page
        var nextPage: Int? = page
        if (page in 1..4) {
            nextPage = nextPage?.plus(1)
        }
        if (page in 2..5) {
            prevPage = prevPage?.minus(1)
        }
        if (page == 1) {
            prevPage = null
        }
        if (page == 5) {
            nextPage = null
        }
        return mapOf(PREVIOUS_PAGE_KEY to prevPage, NEXT_PAGE_KEY to nextPage)
    }

    override suspend fun searchHeroes(name: String?): ApiResponse {
        return ApiResponse(
            success = true,
            message = "ok",
            heroes = findHeroes(name)
        )
    }

    private fun findHeroes(name: String?): List<Hero> {
        val founded = mutableListOf<Hero>()
        return if (!name.isNullOrEmpty()) {
            heroes.forEach { (_, heroes) ->
                heroes.forEach { hero ->
                    if (hero.name.lowercase().contains(name.lowercase())) {
                        founded.add(hero)
                    }
                }
            }
            founded
        } else {
            emptyList()
        }
    }
}