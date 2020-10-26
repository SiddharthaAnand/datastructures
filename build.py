import logging
import build_utils

logging.basicConfig(filename='ds.log', level=logging.ERROR)

###################################################################
#                           BASE STAGE                            #
###################################################################
class Stages:
    def __init__(self, stage_name):
        self.stage_name = stage_name

    def run(self):
        pass


###################################################################
#                       BUILD                                     #
###################################################################
class Build(Stages):
    __name__ = 'build'
    def __init__(self, _files):
        super().__init__(stage_name=__name__)
        self._files = _files

    def run(self):
        pass


###################################################################
#                       TEST                                      #
###################################################################
class Test(Stages):
    def __init__(self):
        __name__ = 'test'
        super().__init__(__name__)

    def run(self):
        pass


###################################################################
#                         COMPILE                                 #
###################################################################
class Compile(Stages):
    _name = 'compile'

    def __init__(self, _files, _ignored):
        super().__init__(stage_name=__name__)
        self._files = _files
        self._ignored = _ignored

    def compile(self):
        import os
        logging.info('Setting current working directory\t{}'.format(os.getcwd()))
        try:
            failed_files = []
            for _dir in self._files:
                for _f in self._files[_dir]:
                    try:
                        if '.java' in _f and _f not in self._ignored:
                            if (os.system('javac {}'.format(_f)) != 0):
                                failed_files.append(_f)
                                logging.info('failed files length: \t{0}'.format(len(failed_files)))
                            logging.info('Compiled files:\t {}'.format(_f))
                    except Exception as e:
                        continue
        except Exception as e:
            raise
        finally:
            if len(failed_files) != 0:
                with open('failed_compilations', 'w') as ff:
                    ff.write('\n'.join(failed_files))
                logging.error('COMPILATION FAILED FOR {} FILES'.format(len(failed_files)))

    def run(self):
        logging.info("RUNNING STAGE:\t {}".format(Compile._name))
        self.compile()
        #TODO Use a logger
        logging.info('COMPILATION COMPLETE')

###################################################################
#                      STAGES RUNNER                              #
###################################################################
class StageRunner:
    def __init__(self, *args):
        """
        :param kwargs: dictionary of stages inheriting Stages class
        """
        assert args is not  None and len(args) != 0
        self.stages = [stage(args[1], args[2]) for stage in args[0]]
        self._files = args[1]
        self.ignored = args[2]

    def run(self):
        for stage in self.stages:
            stage.run()

    def validate(self):
        for stage in self.stages:
            stage.run()


###################################################################
#
###################################################################
if __name__ == '__main__':
    _files = build_utils.get_dirs()
    _ff = open('failed_compilations', 'r')
    _fflist = _ff.readlines()
    _ff.close()

    stage_runner = StageRunner([Compile], _files, _ff)
    stage_runner.run()