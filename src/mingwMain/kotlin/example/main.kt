package example

import com.deflatedpickle.ducknroll.common.api.`object`.Object
import com.deflatedpickle.ducknroll.common.area.Area
import com.deflatedpickle.ducknroll.common.clock.StepTickClock
import com.deflatedpickle.ducknroll.common.api.component.IComponent
import com.deflatedpickle.ducknroll.common.api.matrix.Matrix
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties
import com.deflatedpickle.ducknroll.common.command.HelpCommand
import com.deflatedpickle.ducknroll.common.component.InventoryComponent
import com.deflatedpickle.ducknroll.common.parser.CommandParser
import com.deflatedpickle.ducknroll.common.dimension.Dimension
import com.deflatedpickle.ducknroll.common.entity.Player
import com.deflatedpickle.ducknroll.common.registry.Registries
import com.deflatedpickle.ducknroll.common.world.World
import com.deflatedpickle.ducknroll.common.component.TimeDateComponent
import com.deflatedpickle.ducknroll.common.spot.Spot

fun main() {
    // As funny rat man says, this should be *automated*
    Registries.command.register("help", ::HelpCommand)

    val world = World()

    var input: String?
    val timeDate = TimeDateComponent()
    world.clock = StepTickClock(
        world = world,
        updateCallback = { clock ->
            print("> ")

            input = readLine()

            input?.let { input ->
                if (input.trim() != "") {
                    CommandParser.parse(input)?.let {
                        when (it) {
                            is HelpCommand -> it.run()
                            else -> {
                                clock.step(20)
                                println(timeDate.getTime())
                            }
                        }
                    }
                }
            }

            clock.update()
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
    val spawnArea = Area(18, 10)

    with(normalDimension.getFirstPropertyOfType<MutableList<Area>>().getValue()) {
        add(spawnArea)
    }

    world.getFirstPropertyOfType<MutableList<Dimension>>().getValue().add(normalDimension)

    val player = Player()
    player.setName("Kevin")
    // Add a pre-made component
    player.addComponent(InventoryComponent())
    // Add a custom component
    player.addComponent(object : IComponent {
        override fun update() {
            // println("My custom component (update)")
            println(spawnArea.getProperty<Matrix<Spot>>(
                CommonProperties.SPOT
            ).getValue())
        }

        override fun catchup() {
            // println("My custom component (catchup)")
        }
    })
    spawnArea.spawn(player)

    world.clock?.start()
}