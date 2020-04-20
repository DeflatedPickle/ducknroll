package example

import com.deflatedpickle.ducknroll.common.api.clock.StepTickClock
import com.deflatedpickle.ducknroll.common.api.entity.Player
import com.deflatedpickle.ducknroll.common.world.World

fun main() {
    val world = World()

    var input: String?
    world.clock = StepTickClock(
            constantCallback = {
                print("> ")

                input = readLine()
                if (input != null &&
                        input!!.trim() != "") {
                    it.step(6)
                    println(world.timeDate.getTime())
                }
                else {
                    println(
                            "I'm not quite sure that I" +
                            " understood that, could you try again?"
                    )
                }
            }
    )
    world.spawn(world.timeDate)

    val player = Player("Kevin")
    world.spawn(player)

    world.clock!!.start()
}