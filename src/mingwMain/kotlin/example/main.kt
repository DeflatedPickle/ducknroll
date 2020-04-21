package example

import com.deflatedpickle.ducknroll.common.api.area.Area
import com.deflatedpickle.ducknroll.common.api.clock.StepTickClock
import com.deflatedpickle.ducknroll.common.api.component.IComponent
import com.deflatedpickle.ducknroll.common.api.dimension.Dimension
import com.deflatedpickle.ducknroll.common.api.entity.Player
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties
import com.deflatedpickle.ducknroll.common.world.World
import com.deflatedpickle.ducknroll.common.world.WorldTimeDate

fun main() {
    val world = World()

    var input: String?
    val timeDate = WorldTimeDate()
    world.clock = StepTickClock(
            world = world,
            updateCallback = {
                print("> ")

                input = readLine()
                if (input != null &&
                        input!!.trim() != "") {
                    it.step(20)
                    println(timeDate.getTime())
                }
                else {
                    println(
                            "I'm not quite sure that I" +
                            " understood that, could you try again?"
                    )
                }

                it.update()
            }
    )
    world.addComponent(timeDate)

    // We need to add a general dimension
    // Think of these like the overworld, nether and end in Minecraft
    // These will contain areas
    val normalDimension = Dimension()

    // We add an area to put things in
    // Think of these like a land mass
    // They will have a map and will contain entities and structures
    val spawnArea = Area()
    normalDimension.getFirstPropertyOfType<MutableList<Area>>().getValue().add(spawnArea)
    world.getFirstPropertyOfType<MutableList<Dimension>>().getValue().add(normalDimension)

    val player = Player("Kevin")
    player.addComponent(object : IComponent {
        override fun update() {
            println("bbbbbbbbbbbbbbbb")
        }

        override fun catchup() {
        }
    })
    spawnArea.spawn(player)

    world.clock?.start()
}